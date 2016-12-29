package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ForgotPasswordData;

public class SendEmailEvent extends AbstractSendEmailEvent {

	static final Logger LOG = LoggerFactory.getLogger(SendEmailEvent.class);

	public SendEmailEvent(ForgotPasswordData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
