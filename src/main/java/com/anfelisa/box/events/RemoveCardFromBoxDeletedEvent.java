package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.RemoveCardFromBoxData;

public class RemoveCardFromBoxDeletedEvent extends AbstractRemoveCardFromBoxDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(RemoveCardFromBoxDeletedEvent.class);

	public RemoveCardFromBoxDeletedEvent(RemoveCardFromBoxData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(eventParam, databaseHandle, daoProvider, viewProvider);
	}

	public RemoveCardFromBoxDeletedEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		this(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
