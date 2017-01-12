package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxToCourseAdditionData;

import com.anfelisa.box.commands.AddCourseToBoxCommand;

public abstract class AbstractAddCourseToBoxAction extends Action<BoxToCourseAdditionData> {

	public AbstractAddCourseToBoxAction(DBI jdbi) {
		super("AddCourseToBoxAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new AddCourseToBoxCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
