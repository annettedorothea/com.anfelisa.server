package com.anfelisa.lesson.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.lesson.data.LessonData;

public abstract class AbstractUpdateLessonUpdatedEvent extends Event<LessonData> {

	public AbstractUpdateLessonUpdatedEvent(LessonData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.UpdateLessonUpdatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractUpdateLessonUpdatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.UpdateLessonUpdatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, LessonData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.lesson.views.LessonView.updateLesson" };
	}
	
	

}

/*       S.D.G.       */
