package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.course.data.StudentToCourseAdditionData;

public abstract class AbstractStudentAddedToCourseEvent extends Event<StudentToCourseAdditionData> {

	public AbstractStudentAddedToCourseEvent(StudentToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.StudentAddedToCourseEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, StudentToCourseAdditionData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
