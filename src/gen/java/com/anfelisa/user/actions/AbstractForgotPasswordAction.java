package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.ForgotPasswordData;

import com.anfelisa.user.commands.ForgotPasswordCommand;

public abstract class AbstractForgotPasswordAction extends Action<ForgotPasswordData> {

	public AbstractForgotPasswordAction(ForgotPasswordData actionParam, DatabaseHandle databaseHandle) {
		super("ForgotPasswordAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new ForgotPasswordCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
