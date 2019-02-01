package com.anfelisa.card.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.ICardIdListData;

public class MoveCardsOkEvent extends Event<ICardIdListData> {

	public MoveCardsOkEvent(ICardIdListData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.events.MoveCardsOkEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */