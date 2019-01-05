package com.anfelisa.category.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IEvent;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.*;
import com.anfelisa.ace.JodaObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IEvent createEvent(String eventClass, String json, DatabaseHandle databaseHandle,
		IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (eventClass.equals("com.anfelisa.category.events.CreateCategorySubEvent")) {
				CategoryCreationData data = mapper.readValue(json, CategoryCreationData.class);
				data.migrateLegacyData(json);
				CreateCategorySubEvent event = new CreateCategorySubEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.CreateCategoryRootEvent")) {
				CategoryCreationData data = mapper.readValue(json, CategoryCreationData.class);
				data.migrateLegacyData(json);
				CreateCategoryRootEvent event = new CreateCategoryRootEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.UpdateCategoryOkEvent")) {
				CategoryUpdateData data = mapper.readValue(json, CategoryUpdateData.class);
				data.migrateLegacyData(json);
				UpdateCategoryOkEvent event = new UpdateCategoryOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.DeleteCategoryNoRootEvent")) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCategoryNoRootEvent event = new DeleteCategoryNoRootEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.DeleteCategoryRootEvent")) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCategoryRootEvent event = new DeleteCategoryRootEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.InviteUserOkEvent")) {
				InviteUserData data = mapper.readValue(json, InviteUserData.class);
				data.migrateLegacyData(json);
				InviteUserOkEvent event = new InviteUserOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.RevokeUserAccessOkEvent")) {
				RevokeUserData data = mapper.readValue(json, RevokeUserData.class);
				data.migrateLegacyData(json);
				RevokeUserAccessOkEvent event = new RevokeUserAccessOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.MoveCategoryOkEvent")) {
				CategoryMoveData data = mapper.readValue(json, CategoryMoveData.class);
				data.migrateLegacyData(json);
				MoveCategoryOkEvent event = new MoveCategoryOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}
}

