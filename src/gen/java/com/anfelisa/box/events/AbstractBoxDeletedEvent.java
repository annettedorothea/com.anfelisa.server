package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.box.data.DeleteBoxData;

public abstract class AbstractBoxDeletedEvent extends Event<DeleteBoxData> {

	public AbstractBoxDeletedEvent(DeleteBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxDeletedEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, DeleteBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
