package com.anfelisa.lesson.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonIdData;

public class DeleteLessonDeletedEvent extends AbstractDeleteLessonDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteLessonDeletedEvent.class);

	public DeleteLessonDeletedEvent(LessonIdData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public DeleteLessonDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
