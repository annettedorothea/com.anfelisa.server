package com.anfelisa.category.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryMoveData;

public class MoveCategoryOkEvent extends Event<ICategoryMoveData> {

	public MoveCategoryOkEvent(ICategoryMoveData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.MoveCategoryOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
