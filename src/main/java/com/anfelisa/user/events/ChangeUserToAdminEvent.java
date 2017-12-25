package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.ChangeUserRoleData;

public class ChangeUserToAdminEvent extends AbstractChangeUserToAdminEvent {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserToAdminEvent.class);

	public ChangeUserToAdminEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public ChangeUserToAdminEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
