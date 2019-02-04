package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IBoxData;

public class CreateBoxOkEvent extends Event<IBoxData> {

	public CreateBoxOkEvent(IBoxData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.CreateBoxOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
