/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.category.actions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.IDataContainer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.anfelisa.category.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class AceDataFactory {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IDataContainer createAceData(String className, String json) {
		try {
			if (className.equals("com.anfelisa.category.actions.CreateCategoryAction") ||
					className.equals("com.anfelisa.category.commands.CreateCategoryCommand") ||
					className.equals("com.anfelisa.category.events.CreateCategoryOkEvent")
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
					className.equals("com.anfelisa.category.events.DeleteCategoryOkEvent")
			) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.category.actions.GetCategoryTreeAction")) {
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
			if (className.equals("com.anfelisa.category.actions.ChangeOrderCategoryAction") ||
					className.equals("com.anfelisa.category.commands.ChangeOrderCategoryCommand") ||
					className.equals("com.anfelisa.category.events.ChangeOrderCategoryOkEvent")||
					className.equals("com.anfelisa.category.events.ChangeOrderCategoryNoMoveEvent")
			) {
				CategoryChangeOrderData data = mapper.readValue(json, CategoryChangeOrderData.class);
				data.migrateLegacyData(json);
				return data;
			}
		} catch (IOException e) {
			LOG.error("failed to create ace data {} with data {}", className, json, e);
		}

		return null;
	}
}



/******* S.D.G. *******/



