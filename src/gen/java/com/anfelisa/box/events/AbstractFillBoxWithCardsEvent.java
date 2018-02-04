package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.FillBoxData;

public abstract class AbstractFillBoxWithCardsEvent extends Event<FillBoxData> {

	public AbstractFillBoxWithCardsEvent(FillBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.FillBoxWithCardsEvent", eventParam, databaseHandle);
	}
	
	public AbstractFillBoxWithCardsEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.FillBoxWithCardsEvent", null, databaseHandle);
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
