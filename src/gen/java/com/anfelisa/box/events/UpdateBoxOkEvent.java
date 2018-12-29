package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.BoxUpdateData;

public class UpdateBoxOkEvent extends Event<BoxUpdateData> {

	public UpdateBoxOkEvent(BoxUpdateData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.UpdateBoxOkEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
