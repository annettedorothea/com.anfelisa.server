package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ScheduledCardIdData;

public class CardRemovedFromBoxEvent extends AbstractCardRemovedFromBoxEvent {

	static final Logger LOG = LoggerFactory.getLogger(CardRemovedFromBoxEvent.class);

	public CardRemovedFromBoxEvent(ScheduledCardIdData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
