package com.anfelisa.box.scorecard.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anfelisa.box.commands.ScoreCardCommand;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.BoxModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ReinforceCardDao;
import com.anfelisa.box.models.ReinforceCardModel;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.box.models.ScheduledCardModel;

import de.acegen.Config;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ScoreCardCommandTests {

	private static final String CARD_ID = "cardId";
	private static final String USER_ID = "userId";
	private static final String SCHEDULED_CARD_ID = "scheduledCardId";
	private static final LocalDateTime NOW = LocalDateTime.now();
	private static final String BOX_ID = "boxId";
	private static final String UUID = "uuid";
	@Mock
	private IDaoProvider daoProviderMock;
	@Mock
	private ViewProvider viewProviderMock;
	@Mock
	private PersistenceHandle readonlyHandleMock;
	@Mock
	private PersistenceHandle timelineHandleMock;
	@Mock
	private CustomAppConfiguration appConfigurationMock;
	@Mock
	private ScheduledCardDao scheduledCardDaoMock;
	@Mock
	private BoxDao boxDaoMock;
	@Mock
	private ReinforceCardDao reinforceCardDaoMock;

	private ScoreCardCommand scoreCardCommand;
	private IScoreCardData data;
	private IScheduledCardModel scheduledCard;
	private IBoxModel box;

	@BeforeEach
	public void before() {
		MockitoAnnotations.openMocks(this);
		scoreCardCommand = new ScoreCardCommand(daoProviderMock, viewProviderMock, appConfigurationMock);
		data = new ScoreCardData(UUID);
		data.setBoxId(BOX_ID);
		data.setSystemTime(NOW);
		data.setScheduledCardId(SCHEDULED_CARD_ID);
		data.setUserId(USER_ID);

		scheduledCard = new ScheduledCardModel();
		scheduledCard.setScheduledCardId(SCHEDULED_CARD_ID);
		scheduledCard.setBoxId(BOX_ID);
		scheduledCard.setCardId(CARD_ID);
		box = new BoxModel();
		box.setUserId(USER_ID);
		box.setBoxId(BOX_ID);

		when(daoProviderMock.getScheduledCardDao()).thenReturn(scheduledCardDaoMock);
		when(scheduledCardDaoMock.selectByScheduledCardId(readonlyHandleMock, SCHEDULED_CARD_ID))
				.thenReturn(scheduledCard);

		when(daoProviderMock.getBoxDao()).thenReturn(boxDaoMock);
		when(boxDaoMock.selectByBoxId(readonlyHandleMock, BOX_ID)).thenReturn(box);

		when(daoProviderMock.getReinforceCardDao()).thenReturn(reinforceCardDaoMock);
		when(reinforceCardDaoMock.selectByScheduledCardId(readonlyHandleMock, SCHEDULED_CARD_ID)).thenReturn(null);

		Config config = new Config();
		config.setWriteTimeline(Config.NEVER);
		when(appConfigurationMock.getConfig()).thenReturn(config);

	}

	@ParameterizedTest
	@MethodSource
	public void basicData(Integer quality, Boolean hasReinforceOutcome) {

		scheduledCard.setEf(2.9F);
		scheduledCard.setInterval(3);
		scheduledCard.setCount(3);
		scheduledCard.setN(3);
		data.setScoredCardQuality(quality);

		IScoreCardData actualData = scoreCardCommand.execute(data, readonlyHandleMock, timelineHandleMock);

		assertEquals(UUID, actualData.getNextScheduledCardScheduledCardId());
		assertEquals(NOW, actualData.getNextScheduledCardCreatedDate());
		assertEquals(NOW, actualData.getScoredCardScoredDate());

		assertEquals(CARD_ID, actualData.getCardId());
		assertEquals(BOX_ID, actualData.getBoxId());

		if (hasReinforceOutcome) {
			assertEquals(NOW, actualData.getReinforceCardCreatedDate());
			assertEquals(UUID, actualData.getReinforceCardId());
		} else {
			assertNull(actualData.getReinforceCardCreatedDate());
			assertNull(actualData.getReinforceCardId());
		}

	}

	private static Stream<Arguments> basicData() {
		return Stream.of(
				Arguments.of(0, true),
				Arguments.of(1, true),
				Arguments.of(2, true),
				Arguments.of(3, true),
				Arguments.of(4, false),
				Arguments.of(5, false));
	}

	@ParameterizedTest
	@MethodSource
	public void noMaxCardsPerDay_noMaxInterval(
			Integer quality,
			Float actualEf, Float expectedEf,
			Integer actualInterval, Integer expectedInterval,
			Integer actualN, Integer expectedN) {

		Integer actualCount = 90;

		scheduledCard.setEf(actualEf);
		scheduledCard.setInterval(actualInterval);
		scheduledCard.setCount(actualCount);
		scheduledCard.setN(actualN);
		data.setScoredCardQuality(quality);

		IScoreCardData actualData = scoreCardCommand.execute(data, readonlyHandleMock, timelineHandleMock);

		assertEquals(expectedEf, actualData.getNextScheduledCardEf());
		assertEquals(actualCount + 1, actualData.getNextScheduledCardCount());
		assertEquals(expectedInterval, actualData.getNextScheduledCardInterval());
		assertEquals(quality, actualData.getNextScheduledCardLastQuality());
		assertEquals(expectedN, actualData.getNextScheduledCardN());
		assertEquals(NOW.plusDays(expectedInterval), actualData.getNextScheduledCardScheduledDate());
		assertEquals(0, actualData.getIntervalDifference());
	}

	private static Stream<Arguments> noMaxCardsPerDay_noMaxInterval() {
		return Stream.of(
				Arguments.of(0, 2.5F, 1.7F, 5, 1, 0, 0),
				Arguments.of(0, 2.5F, 1.7F, 5, 1, 1, 0),
				Arguments.of(0, 2.5F, 1.7F, 5, 1, 2, 0),
				Arguments.of(0, 1.4F, 1.3F, 5, 1, 2, 0),
				Arguments.of(0, 1.3F, 1.3F, 5, 1, 2, 0),

				Arguments.of(1, 2.5F, 1.96F, 5, 1, 0, 0),
				Arguments.of(1, 2.5F, 1.96F, 5, 1, 1, 0),
				Arguments.of(1, 2.5F, 1.96F, 5, 1, 2, 0),

				Arguments.of(2, 2.5F, 2.18F, 5, 1, 0, 0),
				Arguments.of(2, 2.5F, 2.18F, 5, 1, 1, 0),
				Arguments.of(2, 2.5F, 2.18F, 5, 1, 2, 0),

				Arguments.of(3, 2.5F, 2.3600001F, 5, 1, 0, 1),
				Arguments.of(3, 2.5F, 2.3600001F, 5, 6, 1, 2),
				Arguments.of(3, 2.5F, 2.3600001F, 5, 13, 2, 3),

				Arguments.of(4, 2.5F, 2.5F, 5, 1, 0, 1),
				Arguments.of(4, 2.5F, 2.5F, 5, 6, 1, 2),
				Arguments.of(4, 2.5F, 2.5F, 5, 13, 2, 3),

				Arguments.of(5, 2.5F, 2.6F, 5, 1, 0, 1),
				Arguments.of(5, 2.5F, 2.6F, 5, 6, 1, 2),
				Arguments.of(5, 2.5F, 2.6F, 5, 13, 2, 3));
	}

	@ParameterizedTest
	@MethodSource
	public void whenNoReinforceCard_expectOutcome(Integer quality, Boolean hasReinforceOutcome) {

		when(reinforceCardDaoMock.selectByScheduledCardId(readonlyHandleMock, SCHEDULED_CARD_ID)).thenReturn(null);

		scheduledCard.setEf(2.5F);
		scheduledCard.setInterval(3);
		scheduledCard.setCount(6);
		scheduledCard.setN(2);
		data.setScoredCardQuality(quality);

		IScoreCardData actualData = scoreCardCommand.execute(data, readonlyHandleMock, timelineHandleMock);

		assertTrue(actualData.hasOutcome("score"));
		if (hasReinforceOutcome) {
			assertTrue(actualData.hasOutcome("reinforce"));
		} else {
			assertFalse(actualData.hasOutcome("reinforce"));
		}
	}

	private static Stream<Arguments> whenNoReinforceCard_expectOutcome() {
		return Stream.of(
				Arguments.of(0, true),
				Arguments.of(1, true),
				Arguments.of(2, true),
				Arguments.of(3, true),
				Arguments.of(4, false),
				Arguments.of(5, false));
	}

	@ParameterizedTest
	@MethodSource
	public void whenReinforceCard_expectOutcome(Integer quality) {

		when(reinforceCardDaoMock.selectByScheduledCardId(readonlyHandleMock, SCHEDULED_CARD_ID))
				.thenReturn(new ReinforceCardModel());

		scheduledCard.setEf(2.5F);
		scheduledCard.setInterval(3);
		scheduledCard.setCount(6);
		scheduledCard.setN(2);
		data.setScoredCardQuality(quality);

		IScoreCardData actualData = scoreCardCommand.execute(data, readonlyHandleMock, timelineHandleMock);

		assertTrue(actualData.hasOutcome("score"));
		assertFalse(actualData.hasOutcome("reinforce"));
	}

	private static Stream<Arguments> whenReinforceCard_expectOutcome() {
		return Stream.of(
				Arguments.of(0),
				Arguments.of(1),
				Arguments.of(2),
				Arguments.of(3),
				Arguments.of(4),
				Arguments.of(5));
	}

	@ParameterizedTest
	@MethodSource
	public void maxCardsPerDay_maxInterval(
			Integer maxInterval, Integer expectedIntervalOffset, Integer calculatedInverval, Integer expectedIntervalDifference,
			Integer maxCardCount,
			List<Integer> nextMaxCardCounts) {

		scheduledCard.setEf(2.5F);
		scheduledCard.setInterval(7);
		scheduledCard.setCount(10);
		scheduledCard.setN(3);
		data.setScoredCardQuality(5);

		box.setMaxInterval(maxInterval);
		box.setMaxCardsPerDay(maxCardCount);

		if (nextMaxCardCounts != null) {
			LocalDateTime newTime = createFrom(NOW.plusDays(calculatedInverval));
			for (Integer nextMaxCardCount : nextMaxCardCounts) {
				LocalDateTime nextDay = createFrom(newTime.plusDays(1));
				when(scheduledCardDaoMock.selectCardCountOfDay(any(), same(BOX_ID),
						eq(newTime),
						eq(nextDay)))
								.thenReturn(nextMaxCardCount);
				newTime = nextDay;
			}
		}

		IScoreCardData actualData = scoreCardCommand.execute(data, readonlyHandleMock, timelineHandleMock);

		int expectedInterval = calculatedInverval + expectedIntervalOffset;
		assertEquals(expectedInterval, actualData.
				getNextScheduledCardInterval());
		assertEquals(NOW.plusDays(expectedInterval), actualData.getNextScheduledCardScheduledDate());
		assertEquals(expectedIntervalDifference, actualData.getIntervalDifference());
	}

	private LocalDateTime createFrom(LocalDateTime localDateTime) {
		return localDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
	}

	private static Stream<Arguments> maxCardsPerDay_maxInterval() {
		return Stream.of(
				Arguments.of(null, 0, 18, 0, null, Arrays.asList()),
				Arguments.of(10, -8, 18, -8, null, Arrays.asList()),
				Arguments.of(null, 2, 18, 2, 5, Arrays.asList(5, 7, 3, 5)),
				Arguments.of(10, 2, 10, -6, 5, Arrays.asList(5, 7, 3, 5)));
	}

}
