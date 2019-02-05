package com.anfelisa.box.actions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.box.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class AceDataFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IDataContainer createAceData(String className, String json) {
		try {
			if (className.equals("com.anfelisa.box.actions.GetBoxesAction")) {
				BoxListData data = mapper.readValue(json, BoxListData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.GetBoxAction")) {
				BoxInfoData data = mapper.readValue(json, BoxInfoData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.CreateBoxAction") ||
					className.equals("com.anfelisa.box.commands.CreateBoxCommand") ||
					className.equals("com.anfelisa.box.events.CreateBoxOkEvent")
			) {
				BoxData data = mapper.readValue(json, BoxData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.UpdateBoxAction") ||
					className.equals("com.anfelisa.box.commands.UpdateBoxCommand") ||
					className.equals("com.anfelisa.box.events.UpdateBoxOkEvent")
			) {
				BoxUpdateData data = mapper.readValue(json, BoxUpdateData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.PostponeCardsAction") ||
					className.equals("com.anfelisa.box.commands.PostponeCardsCommand") ||
					className.equals("com.anfelisa.box.events.PostponeCardsOkEvent")||
					className.equals("com.anfelisa.box.events.PostponeCardsNoDelayEvent")
			) {
				PostponeCardsData data = mapper.readValue(json, PostponeCardsData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.DeleteBoxAction") ||
					className.equals("com.anfelisa.box.commands.DeleteBoxCommand") ||
					className.equals("com.anfelisa.box.events.DeleteBoxOkEvent")
			) {
				DeleteBoxData data = mapper.readValue(json, DeleteBoxData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.LoadNextCardAction")) {
				NextCardData data = mapper.readValue(json, NextCardData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.LoadNextReinforceCardAction")) {
				NextReinforceCardData data = mapper.readValue(json, NextReinforceCardData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.ScheduleNextCardAction") ||
					className.equals("com.anfelisa.box.commands.ScheduleNextCardCommand") ||
					className.equals("com.anfelisa.box.events.ScheduleNextCardOkEvent")
			) {
				ScheduleNextCardData data = mapper.readValue(json, ScheduleNextCardData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.ScheduleCardsAction") ||
					className.equals("com.anfelisa.box.commands.ScheduleCardsCommand") ||
					className.equals("com.anfelisa.box.events.ScheduleCardsOkEvent")||
					className.equals("com.anfelisa.box.events.ScheduleCardsNullOrEmptyEvent")
			) {
				ScheduledCardsData data = mapper.readValue(json, ScheduledCardsData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.ScoreCardAction") ||
					className.equals("com.anfelisa.box.commands.ScoreCardCommand") ||
					className.equals("com.anfelisa.box.events.ScoreCardScoreEvent")||
					className.equals("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent")
			) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.box.actions.ScoreReinforceCardAction") ||
					className.equals("com.anfelisa.box.commands.ScoreReinforceCardCommand") ||
					className.equals("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent")||
					className.equals("com.anfelisa.box.events.ScoreReinforceCardKeepEvent")
			) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				return data;
			}
		} catch (IOException e) {
			LOG.error("failed to create ace data {} with data {}", className, json, e);
		}

		return null;
	}
}

