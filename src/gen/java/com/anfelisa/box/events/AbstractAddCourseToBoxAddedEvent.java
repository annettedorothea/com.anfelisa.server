package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxToCourseAdditionData;

public abstract class AbstractAddCourseToBoxAddedEvent extends Event<BoxToCourseAdditionData> {

	public AbstractAddCourseToBoxAddedEvent(BoxToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.AddCourseToBoxAddedEvent", eventParam, databaseHandle);
	}
	
	public AbstractAddCourseToBoxAddedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.AddCourseToBoxAddedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, BoxToCourseAdditionData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.BoxToCourseView.addCourseToBox" };
	}
	
	

}

/*       S.D.G.       */