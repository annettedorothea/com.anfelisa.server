package com.anfelisa.card.actions;

import java.io.IOException;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IAction;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class ActionFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(ActionFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IAction createAction(String actionClass, String json, Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (actionClass.equals("com.anfelisa.card.actions.CreateCardAction")) {
				CardCreationData data = mapper.readValue(json, CardCreationData.class);
				data.migrateLegacyData(json);
				CreateCardAction action = new CreateCardAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.card.actions.UpdateCardAction")) {
				CardUpdateData data = mapper.readValue(json, CardUpdateData.class);
				data.migrateLegacyData(json);
				UpdateCardAction action = new UpdateCardAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.card.actions.DeleteCardAction")) {
				CardDeleteData data = mapper.readValue(json, CardDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCardAction action = new DeleteCardAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.card.actions.MoveCardsAction")) {
				CardIdListData data = mapper.readValue(json, CardIdListData.class);
				data.migrateLegacyData(json);
				MoveCardsAction action = new MoveCardsAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
		} catch (IOException e) {
			LOG.error("failed to create action {} with data {}", actionClass, json, e);
		}

		return null;
	}
}

