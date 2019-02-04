package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IDeleteBoxData;

public class DeleteBoxOkEvent extends Event<IDeleteBoxData> {

	public DeleteBoxOkEvent(IDeleteBoxData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.DeleteBoxOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
