package com.anfelisa.category.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryMoveData;

public class MoveCategoryNoMoveEvent extends Event<ICategoryMoveData> {

	public MoveCategoryNoMoveEvent(ICategoryMoveData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.MoveCategoryNoMoveEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
