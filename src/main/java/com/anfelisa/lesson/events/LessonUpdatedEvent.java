package com.anfelisa.lesson.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonData;

public class LessonUpdatedEvent extends AbstractLessonUpdatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(LessonUpdatedEvent.class);

	public LessonUpdatedEvent(LessonData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public LessonUpdatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
