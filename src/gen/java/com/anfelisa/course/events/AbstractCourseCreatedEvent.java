package com.anfelisa.course.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.course.data.CourseCreationData;

public abstract class AbstractCourseCreatedEvent extends Event<CourseCreationData> {

	public AbstractCourseCreatedEvent(CourseCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.CourseCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCourseCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.CourseCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CourseCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
