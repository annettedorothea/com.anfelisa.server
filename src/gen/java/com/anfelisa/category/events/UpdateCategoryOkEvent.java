package com.anfelisa.category.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryUpdateData;

public class UpdateCategoryOkEvent extends Event<ICategoryUpdateData> {

	public UpdateCategoryOkEvent(ICategoryUpdateData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.UpdateCategoryOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
