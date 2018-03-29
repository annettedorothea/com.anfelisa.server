package com.anfelisa.lesson.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.lesson.data.LessonIdData;

public abstract class AbstractDeleteLessonDeletedEvent extends Event<LessonIdData> {

	public AbstractDeleteLessonDeletedEvent(LessonIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.DeleteLessonDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractDeleteLessonDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.DeleteLessonDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, LessonIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.lesson.views.LessonView.deleteLesson" };
	}
	
	

}

/*       S.D.G.       */
