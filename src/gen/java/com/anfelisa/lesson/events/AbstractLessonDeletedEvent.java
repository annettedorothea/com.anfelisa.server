package com.anfelisa.lesson.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.lesson.data.LessonIdData;

public abstract class AbstractLessonDeletedEvent extends Event<LessonIdData> {

	public AbstractLessonDeletedEvent(LessonIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.LessonDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractLessonDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.LessonDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, LessonIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
