package com.anfelisa.course.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.course.data.CourseCreationData;

public abstract class AbstractCreateCourseCreatedEvent extends Event<CourseCreationData> {

	public AbstractCreateCourseCreatedEvent(CourseCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.CreateCourseCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCreateCourseCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.CreateCourseCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CourseCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.course.views.CourseView.createCourse" };
	}
	
	

}

/*       S.D.G.       */
