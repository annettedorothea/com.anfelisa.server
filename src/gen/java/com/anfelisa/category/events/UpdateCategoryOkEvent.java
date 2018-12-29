package com.anfelisa.category.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.CategoryUpdateData;

public class UpdateCategoryOkEvent extends Event<CategoryUpdateData> {

	public UpdateCategoryOkEvent(CategoryUpdateData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.UpdateCategoryOkEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
