package com.anfelisa.card.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.card.data.CardDeleteData;

public class DeleteCardOkEvent extends AbstractDeleteCardOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardOkEvent.class);

	public DeleteCardOkEvent(CardDeleteData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public DeleteCardOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
