package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.ChangeUserRoleData;

public class ChangeUserRoleOkEvent extends AbstractChangeUserRoleOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserRoleOkEvent.class);

	public ChangeUserRoleOkEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(eventParam, databaseHandle, daoProvider, viewProvider);
	}

	public ChangeUserRoleOkEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		this(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
