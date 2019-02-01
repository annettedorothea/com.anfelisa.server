package com.anfelisa.box;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.MockitoAnnotations;

import com.anfelisa.ace.App;
import com.anfelisa.ace.AbstractBaseTest;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.TimelineItem;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.DropwizardTestSupport;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

@SuppressWarnings("unused")
public class TestUtils {

	private static final JodaObjectMapper mapper = new JodaObjectMapper();

	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static Response callGetBoxes(
			String uuid, 
			DateTime today
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/boxes/my/?uuid=" + uuid + "&today=" + today, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetBox(
			String uuid, 
			String boxId, DateTime today
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/get?uuid=" + uuid + "&boxId=" + boxId + "&today=" + today, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callCreateBox(com.anfelisa.box.data.IBoxData data, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/create", AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static TimelineItem createCreateBoxOkEventTimelineItem(com.anfelisa.box.data.IBoxData data) throws JsonProcessingException {
		com.anfelisa.box.events.CreateBoxOkEvent event =  new com.anfelisa.box.events.CreateBoxOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callUpdateBox(
			com.anfelisa.box.data.IBoxUpdateData data, 
			String uuid
			, String authorization
		) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/update?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static TimelineItem createUpdateBoxOkEventTimelineItem(com.anfelisa.box.data.IBoxUpdateData data) throws JsonProcessingException {
		com.anfelisa.box.events.UpdateBoxOkEvent event =  new com.anfelisa.box.events.UpdateBoxOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callPostponeCards(
			com.anfelisa.box.data.IPostponeCardsData data, 
			String uuid
			, String authorization
		) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/postpone?uuid=" + uuid, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static TimelineItem createPostponeCardsOkEventTimelineItem(com.anfelisa.box.data.IPostponeCardsData data) throws JsonProcessingException {
		com.anfelisa.box.events.PostponeCardsOkEvent event =  new com.anfelisa.box.events.PostponeCardsOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static TimelineItem createPostponeCardsNoDelayEventTimelineItem(com.anfelisa.box.data.IPostponeCardsData data) throws JsonProcessingException {
		com.anfelisa.box.events.PostponeCardsNoDelayEvent event =  new com.anfelisa.box.events.PostponeCardsNoDelayEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callDeleteBox(
			String uuid, 
			String boxId
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/delete?uuid=" + uuid + "&boxId=" + boxId, AbstractBaseTest.SUPPORT.getLocalPort())).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static TimelineItem createDeleteBoxOkEventTimelineItem(com.anfelisa.box.data.IDeleteBoxData data) throws JsonProcessingException {
		com.anfelisa.box.events.DeleteBoxOkEvent event =  new com.anfelisa.box.events.DeleteBoxOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callLoadNextCard(
			String uuid, 
			String boxId, DateTime today
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/next-card?uuid=" + uuid + "&boxId=" + boxId + "&today=" + today, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callLoadNextReinforceCard(
			String uuid, 
			String boxId
			, String authorization
	) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/next-reinforce-card?uuid=" + uuid + "&boxId=" + boxId, AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callScheduleNextCard(com.anfelisa.box.data.IScheduleNextCardData data, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/schedule-next", AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static TimelineItem createScheduleNextCardOkEventTimelineItem(com.anfelisa.box.data.IScheduleNextCardData data) throws JsonProcessingException {
		com.anfelisa.box.events.ScheduleNextCardOkEvent event =  new com.anfelisa.box.events.ScheduleNextCardOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callScheduleCards(com.anfelisa.box.data.IScheduledCardsData data, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/schedule", AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static TimelineItem createScheduleCardsOkEventTimelineItem(com.anfelisa.box.data.IScheduledCardsData data) throws JsonProcessingException {
		com.anfelisa.box.events.ScheduleCardsOkEvent event =  new com.anfelisa.box.events.ScheduleCardsOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static TimelineItem createScheduleCardsNullOrEmptyEventTimelineItem(com.anfelisa.box.data.IScheduledCardsData data) throws JsonProcessingException {
		com.anfelisa.box.events.ScheduleCardsNullOrEmptyEvent event =  new com.anfelisa.box.events.ScheduleCardsNullOrEmptyEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callScoreCard(com.anfelisa.box.data.IScoreCardData data, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/score", AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static TimelineItem createScoreCardScoreEventTimelineItem(com.anfelisa.box.data.IScoreCardData data) throws JsonProcessingException {
		com.anfelisa.box.events.ScoreCardScoreEvent event =  new com.anfelisa.box.events.ScoreCardScoreEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static TimelineItem createScoreCardScoreAndReinforceEventTimelineItem(com.anfelisa.box.data.IScoreCardData data) throws JsonProcessingException {
		com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent event =  new com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callScoreReinforceCard(com.anfelisa.box.data.IScoreReinforceCardData data, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/reinforce-card/score", AbstractBaseTest.SUPPORT.getLocalPort())).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static TimelineItem createScoreReinforceCardRemoveEventTimelineItem(com.anfelisa.box.data.IScoreReinforceCardData data) throws JsonProcessingException {
		com.anfelisa.box.events.ScoreReinforceCardRemoveEvent event =  new com.anfelisa.box.events.ScoreReinforceCardRemoveEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static TimelineItem createScoreReinforceCardKeepEventTimelineItem(com.anfelisa.box.data.IScoreReinforceCardData data) throws JsonProcessingException {
		com.anfelisa.box.events.ScoreReinforceCardKeepEvent event =  new com.anfelisa.box.events.ScoreReinforceCardKeepEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	
	public static void assertEquals(com.anfelisa.box.models.IBoxModel actual, com.anfelisa.box.models.IBoxModel expected) {
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getMaxInterval(), is(expected.getMaxInterval()));
	}
	public static void assertEquals(com.anfelisa.box.models.IScheduledCardModel actual, com.anfelisa.box.models.IScheduledCardModel expected) {
		assertThat(actual.getScheduledCardId(), is(expected.getScheduledCardId()));
		assertThat(actual.getCardId(), is(expected.getCardId()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
		assertThat(actual.getCreatedDate(), is(expected.getCreatedDate()));
		assertThat(actual.getEf(), is(expected.getEf()));
		assertThat(actual.getInterval(), is(expected.getInterval()));
		assertThat(actual.getN(), is(expected.getN()));
		assertThat(actual.getCount(), is(expected.getCount()));
		assertThat(actual.getScheduledDate(), is(expected.getScheduledDate()));
		assertThat(actual.getLastQuality(), is(expected.getLastQuality()));
		assertThat(actual.getQuality(), is(expected.getQuality()));
		assertThat(actual.getScoredDate(), is(expected.getScoredDate()));
	}
	public static void assertEquals(com.anfelisa.box.models.IReinforceCardModel actual, com.anfelisa.box.models.IReinforceCardModel expected) {
		assertThat(actual.getReinforceCardId(), is(expected.getReinforceCardId()));
		assertThat(actual.getScheduledCardId(), is(expected.getScheduledCardId()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
		assertThat(actual.getChangeDate(), is(expected.getChangeDate()));
	}
	public static void assertEquals(com.anfelisa.box.models.IBoxViewModel actual, com.anfelisa.box.models.IBoxViewModel expected) {
		assertThat(actual.getTodaysCards(), is(expected.getTodaysCards()));
		assertThat(actual.getTotalCards(), is(expected.getTotalCards()));
		assertThat(actual.getReinforceCards(), is(expected.getReinforceCards()));
		assertThat(actual.getMyCards(), is(expected.getMyCards()));
		assertThat(actual.getDaysBehindSchedule(), is(expected.getDaysBehindSchedule()));
		assertThat(actual.getCategoryName(), is(expected.getCategoryName()));
		assertThat(actual.getMaxInterval(), is(expected.getMaxInterval()));
		assertThat(actual.getQuality0Count(), is(expected.getQuality0Count()));
		assertThat(actual.getQuality1Count(), is(expected.getQuality1Count()));
		assertThat(actual.getQuality2Count(), is(expected.getQuality2Count()));
		assertThat(actual.getQuality3Count(), is(expected.getQuality3Count()));
		assertThat(actual.getQuality4Count(), is(expected.getQuality4Count()));
		assertThat(actual.getQuality5Count(), is(expected.getQuality5Count()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
	}
	public static void assertEquals(com.anfelisa.box.models.IBoxInfoModel actual, com.anfelisa.box.models.IBoxInfoModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getToday(), is(expected.getToday()));
	}
	public static void assertEquals(com.anfelisa.box.models.IBoxListModel actual, com.anfelisa.box.models.IBoxListModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getToday(), is(expected.getToday()));
	}
	public static void assertEquals(com.anfelisa.box.models.IPostponeCardsModel actual, com.anfelisa.box.models.IPostponeCardsModel expected) {
		assertThat(actual.getDays(), is(expected.getDays()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getToday(), is(expected.getToday()));
	}
	public static void assertEquals(com.anfelisa.box.models.IBoxUpdateModel actual, com.anfelisa.box.models.IBoxUpdateModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
		assertThat(actual.getMaxInterval(), is(expected.getMaxInterval()));
	}
	public static void assertEquals(com.anfelisa.box.models.INextCardViewModel actual, com.anfelisa.box.models.INextCardViewModel expected) {
		assertThat(actual.getScheduledCardId(), is(expected.getScheduledCardId()));
		assertThat(actual.getCardId(), is(expected.getCardId()));
		assertThat(actual.getScheduledDate(), is(expected.getScheduledDate()));
		assertThat(actual.getLastQuality(), is(expected.getLastQuality()));
		assertThat(actual.getGiven(), is(expected.getGiven()));
		assertThat(actual.getWanted(), is(expected.getWanted()));
		assertThat(actual.getImage(), is(expected.getImage()));
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getRootCategoryId(), is(expected.getRootCategoryId()));
		assertThat(actual.getCount(), is(expected.getCount()));
		assertThat(actual.getScoredDate(), is(expected.getScoredDate()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
	}
	public static void assertEquals(com.anfelisa.box.models.INextCardModel actual, com.anfelisa.box.models.INextCardModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getToday(), is(expected.getToday()));
	}
	public static void assertEquals(com.anfelisa.box.models.IScoreCardModel actual, com.anfelisa.box.models.IScoreCardModel expected) {
		assertThat(actual.getCardId(), is(expected.getCardId()));
		assertThat(actual.getNextScheduledCardScheduledCardId(), is(expected.getNextScheduledCardScheduledCardId()));
		assertThat(actual.getNextScheduledCardCreatedDate(), is(expected.getNextScheduledCardCreatedDate()));
		assertThat(actual.getNextScheduledCardEf(), is(expected.getNextScheduledCardEf()));
		assertThat(actual.getNextScheduledCardInterval(), is(expected.getNextScheduledCardInterval()));
		assertThat(actual.getNextScheduledCardN(), is(expected.getNextScheduledCardN()));
		assertThat(actual.getNextScheduledCardCount(), is(expected.getNextScheduledCardCount()));
		assertThat(actual.getNextScheduledCardScheduledDate(), is(expected.getNextScheduledCardScheduledDate()));
		assertThat(actual.getNextScheduledCardLastQuality(), is(expected.getNextScheduledCardLastQuality()));
		assertThat(actual.getScoredCardScheduledCardId(), is(expected.getScoredCardScheduledCardId()));
		assertThat(actual.getScoredCardQuality(), is(expected.getScoredCardQuality()));
		assertThat(actual.getScoredCardScoredDate(), is(expected.getScoredCardScoredDate()));
		assertThat(actual.getReinforceCardId(), is(expected.getReinforceCardId()));
		assertThat(actual.getReinforceCardCreatedDate(), is(expected.getReinforceCardCreatedDate()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
	}
	public static void assertEquals(com.anfelisa.box.models.INextReinforceCardViewModel actual, com.anfelisa.box.models.INextReinforceCardViewModel expected) {
		assertThat(actual.getReinforceCardId(), is(expected.getReinforceCardId()));
		assertThat(actual.getChangeDate(), is(expected.getChangeDate()));
		assertThat(actual.getLastQuality(), is(expected.getLastQuality()));
		assertThat(actual.getGiven(), is(expected.getGiven()));
		assertThat(actual.getWanted(), is(expected.getWanted()));
		assertThat(actual.getImage(), is(expected.getImage()));
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
	}
	public static void assertEquals(com.anfelisa.box.models.INextReinforceCardModel actual, com.anfelisa.box.models.INextReinforceCardModel expected) {
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.box.models.IScoreReinforceCardModel actual, com.anfelisa.box.models.IScoreReinforceCardModel expected) {
		assertThat(actual.getReinforceCardId(), is(expected.getReinforceCardId()));
		assertThat(actual.getQuality(), is(expected.getQuality()));
		assertThat(actual.getChangeDate(), is(expected.getChangeDate()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.box.models.IScheduledCardsModel actual, com.anfelisa.box.models.IScheduledCardsModel expected) {
		assertThat(actual.getScheduledDate(), is(expected.getScheduledDate()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
	}
	public static void assertEquals(com.anfelisa.box.models.IDeleteBoxModel actual, com.anfelisa.box.models.IDeleteBoxModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
	}
	public static void assertEquals(com.anfelisa.box.models.IScheduleNextCardModel actual, com.anfelisa.box.models.IScheduleNextCardModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getBoxId(), is(expected.getBoxId()));
	}

}

