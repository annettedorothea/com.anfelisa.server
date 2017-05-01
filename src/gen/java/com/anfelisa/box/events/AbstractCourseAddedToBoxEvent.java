package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxToCourseAdditionData;

public abstract class AbstractCourseAddedToBoxEvent extends Event<BoxToCourseAdditionData> {

	public AbstractCourseAddedToBoxEvent(BoxToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CourseAddedToBoxEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */
