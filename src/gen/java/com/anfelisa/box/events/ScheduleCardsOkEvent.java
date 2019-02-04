package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IScheduledCardsData;

public class ScheduleCardsOkEvent extends Event<IScheduledCardsData> {

	public ScheduleCardsOkEvent(IScheduledCardsData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScheduleCardsOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */
