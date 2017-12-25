package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.course.data.CourseData;

public abstract class AbstractCourseUpdatedEvent extends Event<CourseData> {

	public AbstractCourseUpdatedEvent(CourseData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.CourseUpdatedEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CourseData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
