package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseIdData;

public class CourseDeletedEvent extends AbstractCourseDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CourseDeletedEvent.class);

	public CourseDeletedEvent(CourseIdData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CourseDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
