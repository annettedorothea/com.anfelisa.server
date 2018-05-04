package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.DeleteBoxData;

public class DeleteBoxDeletedEvent extends AbstractDeleteBoxDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteBoxDeletedEvent.class);

	public DeleteBoxDeletedEvent(DeleteBoxData eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(eventParam, databaseHandle, daoProvider, viewProvider);
	}

	public DeleteBoxDeletedEvent(DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		this(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
