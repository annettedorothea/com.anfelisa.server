package com.anfelisa.course.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.course.data.CourseIdData;

public abstract class AbstractCourseDeletedEvent extends Event<CourseIdData> {

	public AbstractCourseDeletedEvent(CourseIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.CourseDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCourseDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.CourseDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CourseIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
