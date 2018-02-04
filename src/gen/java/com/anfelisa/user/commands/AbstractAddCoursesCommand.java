package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.AddCoursesData;

public abstract class AbstractAddCoursesCommand extends Command<AddCoursesData> {

	protected static final String success = "success";

	public AbstractAddCoursesCommand(AddCoursesData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.AddCoursesCommand", commandParam, databaseHandle);
	}

	public AbstractAddCoursesCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.AddCoursesCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case success:
			new com.anfelisa.user.events.CoursesAddedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, AddCoursesData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
