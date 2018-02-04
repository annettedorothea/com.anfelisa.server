package com.anfelisa.lesson.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.lesson.data.LessonData;

public abstract class AbstractLessonUpdatedEvent extends Event<LessonData> {

	public AbstractLessonUpdatedEvent(LessonData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.LessonUpdatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractLessonUpdatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.LessonUpdatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, LessonData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
