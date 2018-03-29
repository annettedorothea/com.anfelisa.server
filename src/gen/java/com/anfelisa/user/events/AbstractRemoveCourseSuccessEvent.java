package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.RemoveCourseData;

public abstract class AbstractRemoveCourseSuccessEvent extends Event<RemoveCourseData> {

	public AbstractRemoveCourseSuccessEvent(RemoveCourseData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.RemoveCourseSuccessEvent", eventParam, databaseHandle);
	}
	
	public AbstractRemoveCourseSuccessEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.RemoveCourseSuccessEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, RemoveCourseData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.removeCourse" };
	}
	
	

}

/*       S.D.G.       */
