package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.user.data.AddCoursesData;

public abstract class AbstractCoursesAddedEvent extends Event<AddCoursesData> {

	public AbstractCoursesAddedEvent(AddCoursesData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.CoursesAddedEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, AddCoursesData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */
