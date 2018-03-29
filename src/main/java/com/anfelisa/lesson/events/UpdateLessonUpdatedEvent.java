package com.anfelisa.lesson.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonData;

public class UpdateLessonUpdatedEvent extends AbstractUpdateLessonUpdatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(UpdateLessonUpdatedEvent.class);

	public UpdateLessonUpdatedEvent(LessonData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public UpdateLessonUpdatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
