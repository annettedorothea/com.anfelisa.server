package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.ChangeUserRoleData;

public class ChangeUserToAuthorEvent extends AbstractChangeUserToAuthorEvent {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserToAuthorEvent.class);

	public ChangeUserToAuthorEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
