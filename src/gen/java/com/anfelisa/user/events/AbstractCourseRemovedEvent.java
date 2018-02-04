package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.RemoveCourseData;

public abstract class AbstractCourseRemovedEvent extends Event<RemoveCourseData> {

	public AbstractCourseRemovedEvent(RemoveCourseData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.CourseRemovedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCourseRemovedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.CourseRemovedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, RemoveCourseData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
