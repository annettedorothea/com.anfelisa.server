package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IPostponeCardsData;

public class PostponeCardsOkEvent extends Event<IPostponeCardsData> {

	public PostponeCardsOkEvent(IPostponeCardsData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.PostponeCardsOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
