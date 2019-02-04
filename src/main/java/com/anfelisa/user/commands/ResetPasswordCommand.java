package com.anfelisa.user.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;
import com.anfelisa.user.models.IResetPasswordModel;

public class ResetPasswordCommand extends AbstractResetPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ResetPasswordCommand.class);

	public ResetPasswordCommand(IResetPasswordWithNewPasswordData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		IResetPasswordModel model = daoProvider.getResetPasswordDao().selectByToken(readonlyHandle,  commandData.getToken());
		if (model == null) {
			throwBadRequest("tokenDoesNotExist");
		}
		this.commandData.setUserId(model.getUserId());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
