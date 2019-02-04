package com.anfelisa.user.commands;

import java.util.UUID;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.models.IUserModel;

public class ForgotPasswordCommand extends AbstractForgotPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordCommand.class);

	public ForgotPasswordCommand(IForgotPasswordData actionData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		IUserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle,
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
