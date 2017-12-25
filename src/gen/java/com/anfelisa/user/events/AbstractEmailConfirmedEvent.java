package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.user.data.UsernameData;

public abstract class AbstractEmailConfirmedEvent extends Event<UsernameData> {

	public AbstractEmailConfirmedEvent(UsernameData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.EmailConfirmedEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, UsernameData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
