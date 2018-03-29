package com.anfelisa.lesson.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.lesson.data.LessonCreationData;

public abstract class AbstractCreateLessonCreatedEvent extends Event<LessonCreationData> {

	public AbstractCreateLessonCreatedEvent(LessonCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.CreateLessonCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCreateLessonCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.CreateLessonCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, LessonCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.lesson.views.LessonView.createLesson" };
	}
	
	

}

/*       S.D.G.       */
