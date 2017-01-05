package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.CardIdData;

public class CardDeletedEvent extends AbstractCardDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CardDeletedEvent.class);

	public CardDeletedEvent(CardIdData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
