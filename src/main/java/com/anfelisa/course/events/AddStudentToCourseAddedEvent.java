package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.StudentToCourseAdditionData;

public class AddStudentToCourseAddedEvent extends AbstractAddStudentToCourseAddedEvent {

	static final Logger LOG = LoggerFactory.getLogger(AddStudentToCourseAddedEvent.class);

	public AddStudentToCourseAddedEvent(StudentToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public AddStudentToCourseAddedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
