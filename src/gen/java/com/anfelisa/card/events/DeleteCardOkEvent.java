package com.anfelisa.card.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.ICardDeleteData;

public class DeleteCardOkEvent extends Event<ICardDeleteData> {

	public DeleteCardOkEvent(ICardDeleteData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.events.DeleteCardOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
