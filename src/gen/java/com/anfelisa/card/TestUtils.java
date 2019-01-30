package com.anfelisa.card;

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
	
	public static Response callCreateCard(com.anfelisa.card.data.ICardCreationData data) {
		Client client = new JerseyClientBuilder().build();
		return client.target(String.format("http://localhost:%d/api/card/create", BaseTest.SUPPORT.getLocalPort())).request()
				.post(Entity.json(data));
	}
	
	public static TimelineItem createCreateCardOkEventTimelineItem(com.anfelisa.card.data.ICardCreationData data) throws JsonProcessingException {
		com.anfelisa.card.events.CreateCardOkEvent event =  new com.anfelisa.card.events.CreateCardOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callUpdateCard(
			com.anfelisa.card.data.ICardUpdateData data, 
			String uuid
		) {
		Client client = new JerseyClientBuilder().build();
		return client.target(String.format("http://localhost:%d/api/card/update?uuid=" + uuid, BaseTest.SUPPORT.getLocalPort())).request()
				.put(Entity.json(data));
	}
	
	public static TimelineItem createUpdateCardOkEventTimelineItem(com.anfelisa.card.data.ICardUpdateData data) throws JsonProcessingException {
		com.anfelisa.card.events.UpdateCardOkEvent event =  new com.anfelisa.card.events.UpdateCardOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callDeleteCard(
			String uuid, 
			String cardId
	) {
		Client client = new JerseyClientBuilder().build();
		return client.target(String.format("http://localhost:%d/api/card/delete?uuid=" + uuid + "&cardId=" + cardId, BaseTest.SUPPORT.getLocalPort())).request()
				.delete();
	}
	
	public static TimelineItem createDeleteCardOkEventTimelineItem(com.anfelisa.card.data.ICardDeleteData data) throws JsonProcessingException {
		com.anfelisa.card.events.DeleteCardOkEvent event =  new com.anfelisa.card.events.DeleteCardOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	public static Response callGetDuplicates(
			String uuid, 
			String given, String wanted, Boolean naturalInputOrder, String categoryId
	) {
		Client client = new JerseyClientBuilder().build();
		return client.target(
				String.format("http://localhost:%d/api/cards/search?uuid=" + uuid + "&given=" + given + "&wanted=" + wanted + "&naturalInputOrder=" + naturalInputOrder + "&categoryId=" + categoryId, BaseTest.SUPPORT.getLocalPort()))
				.request().get();
	}
	
	public static Response callGetTranslation(
			String uuid, 
			String sourceValue, String sourceLanguage, String targetLanguage
	) {
		Client client = new JerseyClientBuilder().build();
		return client.target(
				String.format("http://localhost:%d/api/card/translation?uuid=" + uuid + "&sourceValue=" + sourceValue + "&sourceLanguage=" + sourceLanguage + "&targetLanguage=" + targetLanguage, BaseTest.SUPPORT.getLocalPort()))
				.request().get();
	}
	
	public static Response callGetCards(
			String uuid, 
			String categoryId
	) {
		Client client = new JerseyClientBuilder().build();
		return client.target(
				String.format("http://localhost:%d/api/cards?uuid=" + uuid + "&categoryId=" + categoryId, BaseTest.SUPPORT.getLocalPort()))
				.request().get();
	}
	
	public static Response callMoveCards(
			com.anfelisa.card.data.ICardIdListData data, 
			String uuid
		) {
		Client client = new JerseyClientBuilder().build();
		return client.target(String.format("http://localhost:%d/api/cards/move?uuid=" + uuid, BaseTest.SUPPORT.getLocalPort())).request()
				.put(Entity.json(data));
	}
	
	public static TimelineItem createMoveCardsOkEventTimelineItem(com.anfelisa.card.data.ICardIdListData data) throws JsonProcessingException {
		com.anfelisa.card.events.MoveCardsOkEvent event =  new com.anfelisa.card.events.MoveCardsOkEvent(data, null, null, null);
		String json = mapper.writeValueAsString(event.getEventData());
		return new TimelineItem("prepare", null, event.getEventName(), null, json, randomUUID());
	}
	
	public static void assertEquals(com.anfelisa.card.models.ICardModel actual, com.anfelisa.card.models.ICardModel expected) {
		assertThat(actual.getCardId(), is(expected.getCardId()));
		assertThat(actual.getGiven(), is(expected.getGiven()));
		assertThat(actual.getWanted(), is(expected.getWanted()));
		assertThat(actual.getImage(), is(expected.getImage()));
		assertThat(actual.getCardAuthor(), is(expected.getCardAuthor()));
		assertThat(actual.getCardIndex(), is(expected.getCardIndex()));
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getRootCategoryId(), is(expected.getRootCategoryId()));
	}
	public static void assertEquals(com.anfelisa.card.models.ICardUpdateModel actual, com.anfelisa.card.models.ICardUpdateModel expected) {
		assertThat(actual.getCardId(), is(expected.getCardId()));
		assertThat(actual.getGiven(), is(expected.getGiven()));
		assertThat(actual.getWanted(), is(expected.getWanted()));
		assertThat(actual.getImage(), is(expected.getImage()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.card.models.ICardDeleteModel actual, com.anfelisa.card.models.ICardDeleteModel expected) {
		assertThat(actual.getCardId(), is(expected.getCardId()));
		assertThat(actual.getCardIndex(), is(expected.getCardIndex()));
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}
	public static void assertEquals(com.anfelisa.card.models.ICardSearchModel actual, com.anfelisa.card.models.ICardSearchModel expected) {
		assertThat(actual.getGiven(), is(expected.getGiven()));
		assertThat(actual.getWanted(), is(expected.getWanted()));
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getNaturalInputOrder(), is(expected.getNaturalInputOrder()));
	}
	public static void assertEquals(com.anfelisa.card.models.ICardWithCategoryNameModel actual, com.anfelisa.card.models.ICardWithCategoryNameModel expected) {
		assertThat(actual.getCategoryName(), is(expected.getCategoryName()));
	}
	public static void assertEquals(com.anfelisa.card.models.ICardTranslationModel actual, com.anfelisa.card.models.ICardTranslationModel expected) {
		assertThat(actual.getSourceValue(), is(expected.getSourceValue()));
		assertThat(actual.getTargetValue(), is(expected.getTargetValue()));
		assertThat(actual.getSourceLanguage(), is(expected.getSourceLanguage()));
		assertThat(actual.getTargetLanguage(), is(expected.getTargetLanguage()));
	}
	public static void assertEquals(com.anfelisa.card.models.ICardCreationModel actual, com.anfelisa.card.models.ICardCreationModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getUsername(), is(expected.getUsername()));
	}
	public static void assertEquals(com.anfelisa.card.models.ICardListModel actual, com.anfelisa.card.models.ICardListModel expected) {
		assertThat(actual.getUserId(), is(expected.getUserId()));
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
	}
	public static void assertEquals(com.anfelisa.card.models.ICardIdListModel actual, com.anfelisa.card.models.ICardIdListModel expected) {
		assertThat(actual.getCategoryId(), is(expected.getCategoryId()));
		assertThat(actual.getUserId(), is(expected.getUserId()));
	}

}

