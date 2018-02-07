package com.anfelisa.lesson.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonIdData;

public class LessonDeletedEvent extends AbstractLessonDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(LessonDeletedEvent.class);

	public LessonDeletedEvent(LessonIdData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public LessonDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
