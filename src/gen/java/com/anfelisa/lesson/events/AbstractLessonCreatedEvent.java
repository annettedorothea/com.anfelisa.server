package com.anfelisa.lesson.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.lesson.data.LessonCreationData;

public abstract class AbstractLessonCreatedEvent extends Event<LessonCreationData> {

	public AbstractLessonCreatedEvent(LessonCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.events.LessonCreatedEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, LessonCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
