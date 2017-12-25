package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.user.data.ForgotPasswordData;

public abstract class AbstractSendEmailEvent extends Event<ForgotPasswordData> {

	public AbstractSendEmailEvent(ForgotPasswordData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.SendEmailEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ForgotPasswordData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
