package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.AddCoursesData;

public abstract class AbstractAddCoursesSuccessEvent extends Event<AddCoursesData> {

	public AbstractAddCoursesSuccessEvent(AddCoursesData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.AddCoursesSuccessEvent", eventParam, databaseHandle);
	}
	
	public AbstractAddCoursesSuccessEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.AddCoursesSuccessEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, AddCoursesData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.addCourses" };
	}
	
	

}

/*       S.D.G.       */
