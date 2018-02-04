package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxToCourseAdditionData;

public abstract class AbstractCourseAddedToBoxEvent extends Event<BoxToCourseAdditionData> {

	public AbstractCourseAddedToBoxEvent(BoxToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CourseAddedToBoxEvent", eventParam, databaseHandle);
	}
	
	public AbstractCourseAddedToBoxEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CourseAddedToBoxEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, BoxToCourseAdditionData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
