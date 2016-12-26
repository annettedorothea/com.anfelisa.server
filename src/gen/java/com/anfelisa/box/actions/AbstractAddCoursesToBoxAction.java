package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxOfCourseListData;

import com.anfelisa.box.commands.AddCoursesToBoxCommand;

public abstract class AbstractAddCoursesToBoxAction extends Action<BoxOfCourseListData> {

	public AbstractAddCoursesToBoxAction(BoxOfCourseListData actionParam, DatabaseHandle databaseHandle) {
		super("AddCoursesToBoxAction", HttpMethod.PUT, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new AddCoursesToBoxCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
