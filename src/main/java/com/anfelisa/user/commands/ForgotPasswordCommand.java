package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ForgotPasswordCommand extends AbstractForgotPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordCommand.class);

	public ForgotPasswordCommand(IForgotPasswordData actionData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IUserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle,
				this.commandData.getUsername());
		if (user != null) {
			this.commandData.setEmail(user.getEmail());
			this.commandData.setUserId(user.getUserId());
			this.commandData.setOutcome(ok);
		} else {
			this.commandData.setOutcome(doesNotExist);
		}
	}

}

/* S.D.G. */
