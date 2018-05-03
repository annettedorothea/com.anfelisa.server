package com.anfelisa.card.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.card.data.CardCreationData;

public class CreateCardOkEvent extends AbstractCreateCardOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardOkEvent.class);

	public CreateCardOkEvent(CardCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CreateCardOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
