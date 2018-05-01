package com.anfelisa.category.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.category.data.CategoryMoveData;

public abstract class AbstractMoveCategoryOkEvent extends Event<CategoryMoveData> {

	public AbstractMoveCategoryOkEvent(CategoryMoveData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.events.MoveCategoryOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractMoveCategoryOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.events.MoveCategoryOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CategoryMoveData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.category.views.CategoryView.move" };
	}
	
	

}

/*       S.D.G.       */
