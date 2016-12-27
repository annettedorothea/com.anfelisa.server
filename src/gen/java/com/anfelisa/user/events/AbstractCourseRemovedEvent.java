package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.RemoveCourseData;

public abstract class AbstractCourseRemovedEvent extends Event<RemoveCourseData> {

	public AbstractCourseRemovedEvent(RemoveCourseData eventParam, DatabaseHandle databaseHandle) {
		super("CourseRemovedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */
