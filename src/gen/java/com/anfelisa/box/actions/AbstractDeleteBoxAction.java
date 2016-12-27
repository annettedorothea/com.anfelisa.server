package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.DeleteBoxData;

import com.anfelisa.box.commands.DeleteBoxCommand;

public abstract class AbstractDeleteBoxAction extends Action<DeleteBoxData> {

	public AbstractDeleteBoxAction(DeleteBoxData actionParam, DatabaseHandle databaseHandle) {
		super("DeleteBoxAction", HttpMethod.DELETE, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteBoxCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
