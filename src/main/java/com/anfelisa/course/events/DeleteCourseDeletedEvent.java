package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseIdData;

public class DeleteCourseDeletedEvent extends AbstractDeleteCourseDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCourseDeletedEvent.class);

	public DeleteCourseDeletedEvent(CourseIdData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public DeleteCourseDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
