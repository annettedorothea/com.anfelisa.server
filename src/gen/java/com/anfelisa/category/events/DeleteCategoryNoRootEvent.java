package com.anfelisa.category.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryDeleteData;

public class DeleteCategoryNoRootEvent extends Event<ICategoryDeleteData> {

	public DeleteCategoryNoRootEvent(ICategoryDeleteData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.DeleteCategoryNoRootEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
