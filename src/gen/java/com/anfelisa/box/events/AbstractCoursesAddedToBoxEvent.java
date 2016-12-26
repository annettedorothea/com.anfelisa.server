package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxOfCourseListData;

public abstract class AbstractCoursesAddedToBoxEvent extends Event<BoxOfCourseListData> {

	public AbstractCoursesAddedToBoxEvent(BoxOfCourseListData eventParam, DatabaseHandle databaseHandle) {
		super("CoursesAddedToBoxEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */
