package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.course.data.CourseData;

public abstract class AbstractCourseUpdatedEvent extends Event<CourseData> {

	public AbstractCourseUpdatedEvent(CourseData eventParam, DatabaseHandle databaseHandle) {
		super("CourseUpdatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */
