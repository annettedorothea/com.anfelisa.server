package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.CourseSelectionData;

public abstract class AbstractGetCourseSelectionCommand extends Command<CourseSelectionData> {


	public AbstractGetCourseSelectionCommand(CourseSelectionData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.GetCourseSelectionCommand", commandParam, databaseHandle);
	}

	public AbstractGetCourseSelectionCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.GetCourseSelectionCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CourseSelectionData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
