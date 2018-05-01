package com.anfelisa.category.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.category.data.CategoryDeleteData;

public abstract class AbstractDeleteCategoryOkEvent extends Event<CategoryDeleteData> {

	public AbstractDeleteCategoryOkEvent(CategoryDeleteData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.events.DeleteCategoryOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractDeleteCategoryOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.events.DeleteCategoryOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CategoryDeleteData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.category.views.CategoryView.delete" };
	}
	
	

}

/*       S.D.G.       */
