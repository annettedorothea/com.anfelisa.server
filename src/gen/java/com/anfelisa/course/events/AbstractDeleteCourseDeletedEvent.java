package com.anfelisa.course.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.course.data.CourseIdData;

public abstract class AbstractDeleteCourseDeletedEvent extends Event<CourseIdData> {

	public AbstractDeleteCourseDeletedEvent(CourseIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.DeleteCourseDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractDeleteCourseDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.DeleteCourseDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CourseIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.course.views.CourseView.deleteCourse" };
	}
	
	

}

/*       S.D.G.       */
