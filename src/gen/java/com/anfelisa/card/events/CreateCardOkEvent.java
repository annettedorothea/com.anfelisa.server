package com.anfelisa.card.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.ICardCreationData;

public class CreateCardOkEvent extends Event<ICardCreationData> {

	public CreateCardOkEvent(ICardCreationData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.events.CreateCardOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
