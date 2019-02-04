package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IScheduledCardsData;

public class ScheduleCardsNullOrEmptyEvent extends Event<IScheduledCardsData> {

	public ScheduleCardsNullOrEmptyEvent(IScheduledCardsData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScheduleCardsNullOrEmptyEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
