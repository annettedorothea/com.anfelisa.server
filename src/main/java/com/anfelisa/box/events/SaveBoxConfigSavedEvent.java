package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxConfigData;

public class SaveBoxConfigSavedEvent extends AbstractSaveBoxConfigSavedEvent {

	static final Logger LOG = LoggerFactory.getLogger(SaveBoxConfigSavedEvent.class);

	public SaveBoxConfigSavedEvent(BoxConfigData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public SaveBoxConfigSavedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
