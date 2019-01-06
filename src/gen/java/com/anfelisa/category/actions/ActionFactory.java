package com.anfelisa.category.actions;

import java.io.IOException;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IAction;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class ActionFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(ActionFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IAction createAction(String actionClass, String json, Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (actionClass.equals("com.anfelisa.category.actions.CreateCategoryAction")) {
				CategoryCreationData data = mapper.readValue(json, CategoryCreationData.class);
				data.migrateLegacyData(json);
				CreateCategoryAction action = new CreateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.category.actions.CreateCategoryAction")) {
				CategoryCreationData data = mapper.readValue(json, CategoryCreationData.class);
				data.migrateLegacyData(json);
				CreateCategoryAction action = new CreateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.category.actions.UpdateCategoryAction")) {
				CategoryUpdateData data = mapper.readValue(json, CategoryUpdateData.class);
				data.migrateLegacyData(json);
				UpdateCategoryAction action = new UpdateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.category.actions.DeleteCategoryAction")) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCategoryAction action = new DeleteCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.category.actions.DeleteCategoryAction")) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCategoryAction action = new DeleteCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.category.actions.InviteUserAction")) {
				InviteUserData data = mapper.readValue(json, InviteUserData.class);
				data.migrateLegacyData(json);
				InviteUserAction action = new InviteUserAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.category.actions.RevokeUserAccessAction")) {
				RevokeUserData data = mapper.readValue(json, RevokeUserData.class);
				data.migrateLegacyData(json);
				RevokeUserAccessAction action = new RevokeUserAccessAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
			if (actionClass.equals("com.anfelisa.category.actions.MoveCategoryAction")) {
				CategoryMoveData data = mapper.readValue(json, CategoryMoveData.class);
				data.migrateLegacyData(json);
				MoveCategoryAction action = new MoveCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider);
				return action;
			}
		} catch (IOException e) {
			LOG.error("failed to create action {} with data {}", actionClass, json, e);
		}

		return null;
	}
}

