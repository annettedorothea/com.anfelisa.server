package com.anfelisa.mandator.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.mandator.data.MandatorCreationData;

import com.anfelisa.mandator.commands.CreateMandatorCommand;

public abstract class AbstractCreateMandatorAction extends Action<MandatorCreationData> {

	public AbstractCreateMandatorAction(MandatorCreationData actionParam, DatabaseHandle databaseHandle) {
		super("CreateMandatorAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new CreateMandatorCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
