package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseData;

public class UpdateCourseUpdatedEvent extends AbstractUpdateCourseUpdatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCourseUpdatedEvent.class);

	public UpdateCourseUpdatedEvent(CourseData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public UpdateCourseUpdatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
