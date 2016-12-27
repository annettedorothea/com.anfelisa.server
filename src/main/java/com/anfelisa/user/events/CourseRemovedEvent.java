package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.RemoveCourseData;

public class CourseRemovedEvent extends AbstractCourseRemovedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CourseRemovedEvent.class);

	public CourseRemovedEvent(RemoveCourseData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
