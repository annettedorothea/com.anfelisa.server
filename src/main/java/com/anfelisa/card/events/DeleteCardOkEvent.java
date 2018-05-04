package com.anfelisa.card.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.CardDeleteData;

public class DeleteCardOkEvent extends AbstractDeleteCardOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardOkEvent.class);

	public DeleteCardOkEvent(CardDeleteData eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(eventParam, databaseHandle, daoProvider, viewProvider);
	}

	public DeleteCardOkEvent(DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		this(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
