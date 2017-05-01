package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.AddCoursesData;

public abstract class AbstractCoursesAddedEvent extends Event<AddCoursesData> {

	public AbstractCoursesAddedEvent(AddCoursesData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.CoursesAddedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */
