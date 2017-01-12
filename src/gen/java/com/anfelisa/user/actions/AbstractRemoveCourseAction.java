package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.RemoveCourseData;

import com.anfelisa.user.commands.RemoveCourseCommand;

public abstract class AbstractRemoveCourseAction extends Action<RemoveCourseData> {

	public AbstractRemoveCourseAction(DBI jdbi) {
		super("RemoveCourseAction", HttpMethod.DELETE, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new RemoveCourseCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
