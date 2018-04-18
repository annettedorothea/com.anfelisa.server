package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.CardIdData;

public class DeleteCardDeletedEvent extends AbstractDeleteCardDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardDeletedEvent.class);

	public DeleteCardDeletedEvent(CardIdData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public DeleteCardDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
