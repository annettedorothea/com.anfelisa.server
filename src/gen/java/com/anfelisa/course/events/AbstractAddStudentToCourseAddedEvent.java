package com.anfelisa.course.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.course.data.StudentToCourseAdditionData;

public abstract class AbstractAddStudentToCourseAddedEvent extends Event<StudentToCourseAdditionData> {

	public AbstractAddStudentToCourseAddedEvent(StudentToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.AddStudentToCourseAddedEvent", eventParam, databaseHandle);
	}
	
	public AbstractAddStudentToCourseAddedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.events.AddStudentToCourseAddedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, StudentToCourseAdditionData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.course.views.StudentOfCourseView.addStudentToCourse" };
	}
	
	

}

/*       S.D.G.       */
