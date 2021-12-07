package com.anfelisa.box.scorecard.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
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

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void before() {
		MockitoAnnotations.initMocks(this);
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

		when(daoProviderMock.getScheduledCardDao()).thenReturn(scheduledCardDaoMock);
		when(scheduledCardDaoMock.selectByScheduledCardId(readonlyHandleMock, SCHEDULED_CARD_ID)).thenReturn(scheduledCard);
		
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
	public void noMaxCardsPerDay_noMaxInterval(Integer quality, Float actualEf, Float expectedEf, Integer expectedInterval, Integer expectedN) {
		
		Integer actualInterval = 5; // parameter
		Integer actualCount = 90;
		Integer actualN = 3; // parameter

		scheduledCard.setEf(actualEf );
		scheduledCard.setInterval(actualInterval );
		scheduledCard.setCount(actualCount );
		scheduledCard.setN(actualN );
		data.setScoredCardQuality(quality);

		scoreCardCommand.execute(data, readonlyHandleMock, timelineHandleMock);
		
		assertEquals(expectedEf, data.getNextScheduledCardEf()); 
		assertEquals(actualCount+1, data.getNextScheduledCardCount()); 
		assertEquals(NOW, data.getNextScheduledCardCreatedDate()); 
		assertEquals(expectedInterval, data.getNextScheduledCardInterval()); 
		assertEquals(quality, data.getNextScheduledCardLastQuality()); 
		assertEquals(expectedN, data.getNextScheduledCardN()); 
		assertEquals(UUID, data.getNextScheduledCardScheduledCardId()); 
		assertEquals(NOW.plusDays(expectedInterval), data.getNextScheduledCardScheduledDate());

		assertEquals(CARD_ID, data.getCardId());
		assertEquals(BOX_ID, data.getBoxId());

		assertTrue(data.hasOutcome("score"));
		if (quality < 4) {
			assertTrue(data.hasOutcome("reinforce"));
		} else {
			assertFalse(data.hasOutcome("reinforce"));
		}
	}
	
	private static Stream<Arguments> noMaxCardsPerDay_noMaxInterval() {
	    return Stream.of(
	      Arguments.of(0, 2.5F, 1.7F, 1, 0),
	      Arguments.of(1, 2.5F, 1.96F, 1, 0),
	      Arguments.of(2, 2.5F, 2.18F, 1, 0),
	      Arguments.of(3, 2.5F, 2.3600001F, 13, 4),
	      Arguments.of(4, 2.5F, 2.5F, 13, 4),
	      Arguments.of(5, 2.5F, 2.6F, 13, 4)
	    );
	}
	
}
