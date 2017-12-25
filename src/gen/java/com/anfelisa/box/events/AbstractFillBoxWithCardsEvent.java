package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.box.data.FillBoxData;

public abstract class AbstractFillBoxWithCardsEvent extends Event<FillBoxData> {

	public AbstractFillBoxWithCardsEvent(FillBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.FillBoxWithCardsEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, FillBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
