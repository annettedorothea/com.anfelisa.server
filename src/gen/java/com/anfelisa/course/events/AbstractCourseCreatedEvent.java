package com.anfelisa.course.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.course.data.CourseCreationData;

public abstract class AbstractCourseCreatedEvent extends Event<CourseCreationData> {

	public AbstractCourseCreatedEvent(CourseCreationData eventParam, DatabaseHandle databaseHandle) {
		super("CourseCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */
