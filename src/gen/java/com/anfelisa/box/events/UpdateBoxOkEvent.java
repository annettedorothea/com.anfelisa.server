package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IBoxUpdateData;

public class UpdateBoxOkEvent extends Event<IBoxUpdateData> {

	public UpdateBoxOkEvent(IBoxUpdateData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.UpdateBoxOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
