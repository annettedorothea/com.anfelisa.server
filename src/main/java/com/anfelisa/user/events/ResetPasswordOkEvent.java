package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.ResetPasswordData;

public class ResetPasswordOkEvent extends AbstractResetPasswordOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(ResetPasswordOkEvent.class);

	public ResetPasswordOkEvent(ResetPasswordData eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(eventParam, databaseHandle, daoProvider, viewProvider);
	}

	public ResetPasswordOkEvent(DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		this(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
