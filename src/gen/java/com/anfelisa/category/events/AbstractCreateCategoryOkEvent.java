package com.anfelisa.category.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.category.data.CategoryCreationData;

public abstract class AbstractCreateCategoryOkEvent extends Event<CategoryCreationData> {

	public AbstractCreateCategoryOkEvent(CategoryCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.events.CreateCategoryOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractCreateCategoryOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.events.CreateCategoryOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CategoryCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.category.views.CategoryView.insert" };
	}
	
	

}

/*       S.D.G.       */
