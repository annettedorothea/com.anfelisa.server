package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxConfigData;

public class BoxConfigSavedEvent extends AbstractBoxConfigSavedEvent {

	static final Logger LOG = LoggerFactory.getLogger(BoxConfigSavedEvent.class);

	public BoxConfigSavedEvent(BoxConfigData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public BoxConfigSavedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
