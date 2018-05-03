package com.anfelisa.card.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.card.data.CardUpdateData;

public class UpdateCardOkEvent extends AbstractUpdateCardOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCardOkEvent.class);

	public UpdateCardOkEvent(CardUpdateData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public UpdateCardOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
