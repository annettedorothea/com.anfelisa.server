package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.AddCoursesData;

import com.anfelisa.user.commands.AddCoursesCommand;

public abstract class AbstractAddCoursesAction extends Action<AddCoursesData> {

	public AbstractAddCoursesAction(AddCoursesData actionParam, DatabaseHandle databaseHandle) {
		super("AddCoursesAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new AddCoursesCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
