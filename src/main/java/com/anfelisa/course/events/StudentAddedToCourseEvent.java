package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.StudentToCourseAdditionData;

public class StudentAddedToCourseEvent extends AbstractStudentAddedToCourseEvent {

	static final Logger LOG = LoggerFactory.getLogger(StudentAddedToCourseEvent.class);

	public StudentAddedToCourseEvent(StudentToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public StudentAddedToCourseEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
