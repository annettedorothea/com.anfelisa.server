package com.anfelisa.lesson.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.lesson.data.LessonCreationData;

public abstract class AbstractLessonCreatedEvent extends Event<LessonCreationData> {

	public AbstractLessonCreatedEvent(LessonCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.LessonCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */
