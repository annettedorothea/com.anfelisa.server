package com.anfelisa.lesson.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonCreationData;

public class CreateLessonCreatedEvent extends AbstractCreateLessonCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CreateLessonCreatedEvent.class);

	public CreateLessonCreatedEvent(LessonCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CreateLessonCreatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
