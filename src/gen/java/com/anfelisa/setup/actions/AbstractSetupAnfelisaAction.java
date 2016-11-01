package com.anfelisa.setup.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.setup.data.SetupData;

import com.anfelisa.setup.commands.SetupAnfelisaCommand;

public abstract class AbstractSetupAnfelisaAction extends Action<SetupData> {

	public AbstractSetupAnfelisaAction(SetupData actionParam, DatabaseHandle databaseHandle) {
		super("SetupAnfelisaAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new SetupAnfelisaCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
