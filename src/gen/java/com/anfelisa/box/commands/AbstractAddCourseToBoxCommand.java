package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxToCourseAdditionData;

public abstract class AbstractAddCourseToBoxCommand extends Command<BoxToCourseAdditionData> {

	protected static final String added = "added";

	public AbstractAddCourseToBoxCommand(BoxToCourseAdditionData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.AddCourseToBoxCommand", commandParam, databaseHandle);
	}

	public AbstractAddCourseToBoxCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.AddCourseToBoxCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case added:
			new com.anfelisa.box.events.CourseAddedToBoxEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, BoxToCourseAdditionData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
