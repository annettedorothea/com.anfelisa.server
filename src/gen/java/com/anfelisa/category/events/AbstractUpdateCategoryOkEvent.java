package com.anfelisa.category.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.category.data.CategoryUpdateData;

public abstract class AbstractUpdateCategoryOkEvent extends Event<CategoryUpdateData> {

	public AbstractUpdateCategoryOkEvent(CategoryUpdateData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.events.UpdateCategoryOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractUpdateCategoryOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.events.UpdateCategoryOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CategoryUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.category.views.CategoryView.update" };
	}
	
	

}

/*       S.D.G.       */
