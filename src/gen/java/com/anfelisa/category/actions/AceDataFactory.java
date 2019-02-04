package com.anfelisa.category.actions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.category.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class AceDataFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IDataContainer createAceData(String className, String json) {
		try {
			if (className.equals("com.anfelisa.category.actions.CreateCategoryAction") ||
					className.equals("com.anfelisa.category.commands.CreateCategoryCommand") ||
					className.equals("com.anfelisa.category.events.CreateCategorySubEvent")||
					className.equals("com.anfelisa.category.events.CreateCategoryRootEvent")
			) {
				CategoryCreationData data = mapper.readValue(json, CategoryCreationData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.category.actions.UpdateCategoryAction") ||
					className.equals("com.anfelisa.category.commands.UpdateCategoryCommand") ||
					className.equals("com.anfelisa.category.events.UpdateCategoryOkEvent")
			) {
				CategoryUpdateData data = mapper.readValue(json, CategoryUpdateData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.category.actions.DeleteCategoryAction") ||
					className.equals("com.anfelisa.category.commands.DeleteCategoryCommand") ||
					className.equals("com.anfelisa.category.events.DeleteCategoryNoRootEvent")||
					className.equals("com.anfelisa.category.events.DeleteCategoryRootEvent")
			) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.category.actions.InviteUserAction") ||
					className.equals("com.anfelisa.category.commands.InviteUserCommand") ||
					className.equals("com.anfelisa.category.events.InviteUserOkEvent")||
					className.equals("com.anfelisa.category.events.InviteUserHasAccessEvent")
			) {
				InviteUserData data = mapper.readValue(json, InviteUserData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.category.actions.RevokeUserAccessAction") ||
					className.equals("com.anfelisa.category.commands.RevokeUserAccessCommand") ||
					className.equals("com.anfelisa.category.events.RevokeUserAccessOkEvent")||
					className.equals("com.anfelisa.category.events.RevokeUserAccessHasNoAccessEvent")
			) {
				RevokeUserData data = mapper.readValue(json, RevokeUserData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.category.actions.GetUsersWithAccessAction") ||
					className.equals("com.anfelisa.category.commands.GetUsersWithAccessCommand") 
			) {
				UserWithAccessListData data = mapper.readValue(json, UserWithAccessListData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.category.actions.GetCategoryTreeAction") ||
					className.equals("com.anfelisa.category.commands.GetCategoryTreeCommand") 
			) {
				CategoryTreeData data = mapper.readValue(json, CategoryTreeData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.category.actions.MoveCategoryAction") ||
					className.equals("com.anfelisa.category.commands.MoveCategoryCommand") ||
					className.equals("com.anfelisa.category.events.MoveCategoryOkEvent")||
					className.equals("com.anfelisa.category.events.MoveCategoryNoMoveEvent")
			) {
				CategoryMoveData data = mapper.readValue(json, CategoryMoveData.class);
				data.migrateLegacyData(json);
				return data;
			}
		} catch (IOException e) {
			LOG.error("failed to create ace data {} with data {}", className, json, e);
		}

		return null;
	}
}

