package com.anfelisa.lesson.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonCreationData;

public class LessonCreatedEvent extends AbstractLessonCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(LessonCreatedEvent.class);

	public LessonCreatedEvent(LessonCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public LessonCreatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
