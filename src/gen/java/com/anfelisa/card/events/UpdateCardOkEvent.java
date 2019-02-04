package com.anfelisa.card.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.ICardUpdateData;

public class UpdateCardOkEvent extends Event<ICardUpdateData> {

	public UpdateCardOkEvent(ICardUpdateData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.events.UpdateCardOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
