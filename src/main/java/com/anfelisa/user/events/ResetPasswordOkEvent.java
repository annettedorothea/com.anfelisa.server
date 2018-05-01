package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ResetPasswordData;

public class ResetPasswordOkEvent extends AbstractResetPasswordOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(ResetPasswordOkEvent.class);

	public ResetPasswordOkEvent(ResetPasswordData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public ResetPasswordOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
