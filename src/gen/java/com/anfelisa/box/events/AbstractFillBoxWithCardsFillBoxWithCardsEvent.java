package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.FillBoxData;

public abstract class AbstractFillBoxWithCardsFillBoxWithCardsEvent extends Event<FillBoxData> {

	public AbstractFillBoxWithCardsFillBoxWithCardsEvent(FillBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.FillBoxWithCardsFillBoxWithCardsEvent", eventParam, databaseHandle);
	}
	
	public AbstractFillBoxWithCardsFillBoxWithCardsEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.FillBoxWithCardsFillBoxWithCardsEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, FillBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.BoxView.fillBoxWithCards" };
	}
	
	

}

/*       S.D.G.       */
