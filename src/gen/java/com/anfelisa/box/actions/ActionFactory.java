package com.anfelisa.box.actions;

import java.io.IOException;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IAction;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class ActionFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(ActionFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IAction createAction(String actionClass, String json, Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (actionClass.equals("com.anfelisa.box.actions.CreateBoxAction")) {
				BoxData data = mapper.readValue(json, BoxData.class);
				data.migrateLegacyData(json);
				CreateBoxAction action = new CreateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.box.actions.UpdateBoxAction")) {
				BoxUpdateData data = mapper.readValue(json, BoxUpdateData.class);
				data.migrateLegacyData(json);
				UpdateBoxAction action = new UpdateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.box.actions.PostponeCardsAction")) {
				PostponeCardsData data = mapper.readValue(json, PostponeCardsData.class);
				data.migrateLegacyData(json);
				PostponeCardsAction action = new PostponeCardsAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.box.actions.DeleteBoxAction")) {
				DeleteBoxData data = mapper.readValue(json, DeleteBoxData.class);
				data.migrateLegacyData(json);
				DeleteBoxAction action = new DeleteBoxAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.box.actions.ScheduleNextCardAction")) {
				ScheduleNextCardData data = mapper.readValue(json, ScheduleNextCardData.class);
				data.migrateLegacyData(json);
				ScheduleNextCardAction action = new ScheduleNextCardAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.box.actions.ScheduleCardsAction")) {
				ScheduledCardsData data = mapper.readValue(json, ScheduledCardsData.class);
				data.migrateLegacyData(json);
				ScheduleCardsAction action = new ScheduleCardsAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.box.actions.ScoreCardAction")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardAction action = new ScoreCardAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.box.actions.ScoreCardAction")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardAction action = new ScoreCardAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.box.actions.ScoreReinforceCardAction")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardAction action = new ScoreReinforceCardAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.box.actions.ScoreReinforceCardAction")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardAction action = new ScoreReinforceCardAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
		} catch (IOException e) {
			LOG.error("failed to create action {} with data {}", actionClass, json, e);
		}

		return null;
	}
}

