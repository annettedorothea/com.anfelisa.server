package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.ForgotPasswordData;

public class SendEmailEvent extends AbstractSendEmailEvent {

	static final Logger LOG = LoggerFactory.getLogger(SendEmailEvent.class);

	public SendEmailEvent(ForgotPasswordData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public SendEmailEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
