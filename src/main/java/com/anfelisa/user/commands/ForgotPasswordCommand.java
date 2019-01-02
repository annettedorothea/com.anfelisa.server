package com.anfelisa.user.commands;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.models.IUserModel;

public class ForgotPasswordCommand extends AbstractForgotPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordCommand.class);

	public ForgotPasswordCommand(ForgotPasswordData commandParam, DatabaseHandle databaseHandle,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IUserModel user = daoProvider.getUserDao().selectByUsername(this.getDatabaseHandle().getHandle(),
				this.commandData.getUsername());
		if (user != null) {
			this.commandData.setEmail(user.getEmail());
			this.commandData.setUserId(user.getUserId());
			this.commandData.setToken(UUID.randomUUID().toString());
			this.commandData.setOutcome(ok);
		} else {
			this.commandData.setOutcome(doesNotExist);
		}
	}

}

/* S.D.G. */
