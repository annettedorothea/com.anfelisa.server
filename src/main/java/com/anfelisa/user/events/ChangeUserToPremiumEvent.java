package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ChangeUserRoleData;

public class ChangeUserToPremiumEvent extends AbstractChangeUserToPremiumEvent {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserToPremiumEvent.class);

	public ChangeUserToPremiumEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */