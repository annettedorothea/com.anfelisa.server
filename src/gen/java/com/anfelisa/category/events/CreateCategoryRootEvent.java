package com.anfelisa.category.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryCreationData;

public class CreateCategoryRootEvent extends Event<ICategoryCreationData> {

	public CreateCategoryRootEvent(ICategoryCreationData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.CreateCategoryRootEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
