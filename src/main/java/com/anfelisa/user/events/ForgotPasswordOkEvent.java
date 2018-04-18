package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ForgotPasswordData;

public class ForgotPasswordOkEvent extends AbstractForgotPasswordOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordOkEvent.class);

	public ForgotPasswordOkEvent(ForgotPasswordData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public ForgotPasswordOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
