package com.anfelisa.course.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.course.data.CourseData;

public abstract class AbstractUpdateCourseUpdatedEvent extends Event<CourseData> {

	public AbstractUpdateCourseUpdatedEvent(CourseData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.UpdateCourseUpdatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractUpdateCourseUpdatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.UpdateCourseUpdatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CourseData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.course.views.CourseView.updateCourse" };
	}
	
	

}

/*       S.D.G.       */
