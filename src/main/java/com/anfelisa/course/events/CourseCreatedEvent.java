package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseCreationData;

public class CourseCreatedEvent extends AbstractCourseCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CourseCreatedEvent.class);

	public CourseCreatedEvent(CourseCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
