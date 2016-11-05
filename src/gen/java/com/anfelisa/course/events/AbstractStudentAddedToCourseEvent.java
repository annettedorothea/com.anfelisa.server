package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.course.data.StudentToCourseAdditionData;

public abstract class AbstractStudentAddedToCourseEvent extends Event<StudentToCourseAdditionData> {

	public AbstractStudentAddedToCourseEvent(StudentToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super("StudentAddedToCourseEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */
