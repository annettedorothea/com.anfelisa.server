package com.anfelisa.lesson.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.lesson.data.LessonData;

public abstract class AbstractLessonUpdatedEvent extends Event<LessonData> {

	public AbstractLessonUpdatedEvent(LessonData eventParam, DatabaseHandle databaseHandle) {
		super("LessonUpdatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */
