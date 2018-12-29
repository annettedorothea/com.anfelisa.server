package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScheduleNextCardData;

public class ScheduleNextCardOkEvent extends Event<ScheduleNextCardData> {

	public ScheduleNextCardOkEvent(ScheduleNextCardData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScheduleNextCardOkEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
