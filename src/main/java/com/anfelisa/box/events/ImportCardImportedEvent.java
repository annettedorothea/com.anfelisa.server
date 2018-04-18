package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.CardCreationData;

public class ImportCardImportedEvent extends AbstractImportCardImportedEvent {

	static final Logger LOG = LoggerFactory.getLogger(ImportCardImportedEvent.class);

	public ImportCardImportedEvent(CardCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public ImportCardImportedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
