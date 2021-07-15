/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.category.events;

import de.acegen.IDaoProvider;
import de.acegen.IEvent;
import de.acegen.ViewProvider;
import com.anfelisa.category.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.acegen.IDataContainer;
import de.acegen.CustomAppConfiguration;
import de.acegen.PersistenceHandle;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class EventReplayService {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventReplayService.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static void replayEvent(String eventClass, String json, PersistenceHandle handle, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		try {
			if (eventClass.equals("com.anfelisa.category.events.CreateCategoryOkEvent")) {
				CategoryCreationData data = mapper.readValue(json, CategoryCreationData.class);
				data.migrateLegacyData(json);
				CreateCategoryOkEvent event = new CreateCategoryOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.category.events.UpdateCategoryOkEvent")) {
				CategoryUpdateData data = mapper.readValue(json, CategoryUpdateData.class);
				data.migrateLegacyData(json);
				UpdateCategoryOkEvent event = new UpdateCategoryOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.category.events.DeleteCategoryOkEvent")) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCategoryOkEvent event = new DeleteCategoryOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.category.events.MoveCategoryOkEvent")) {
				CategoryMoveData data = mapper.readValue(json, CategoryMoveData.class);
				data.migrateLegacyData(json);
				MoveCategoryOkEvent event = new MoveCategoryOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.category.events.ChangeOrderCategoryOkEvent")) {
				CategoryChangeOrderData data = mapper.readValue(json, CategoryChangeOrderData.class);
				data.migrateLegacyData(json);
				ChangeOrderCategoryOkEvent event = new ChangeOrderCategoryOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.category.events.InviteUserToCategoryOkEvent")) {
				UserToCategoryInvitationData data = mapper.readValue(json, UserToCategoryInvitationData.class);
				data.migrateLegacyData(json);
				InviteUserToCategoryOkEvent event = new InviteUserToCategoryOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
		} catch (IOException e) {
			LOG.error("failed to replay event {} with data {}", eventClass, json, e);
		}
	}

}



/******* S.D.G. *******/



