package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxToCourseAdditionData;

import com.anfelisa.box.commands.AddCourseToBoxCommand;

public abstract class AbstractAddCourseToBoxAction extends Action<BoxToCourseAdditionData> {

	public AbstractAddCourseToBoxAction(BoxToCourseAdditionData actionParam, DatabaseHandle databaseHandle) {
		super("AddCourseToBoxAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new AddCourseToBoxCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
