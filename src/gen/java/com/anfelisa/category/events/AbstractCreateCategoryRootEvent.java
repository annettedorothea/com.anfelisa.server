package com.anfelisa.category.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.CategoryCreationData;

public abstract class AbstractCreateCategoryRootEvent extends Event<CategoryCreationData> {

	public AbstractCreateCategoryRootEvent(CategoryCreationData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.CreateCategoryRootEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractCreateCategoryRootEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.CreateCategoryRootEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CategoryCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.category.views.CategoryView.insert", "com.anfelisa.category.views.UserAccessToCategoryView.grantAccess" };
	}
	
	

}

/*       S.D.G.       */
