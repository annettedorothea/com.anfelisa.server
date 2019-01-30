package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;
import com.anfelisa.user.models.IResetPasswordModel;

public class ResetPasswordCommand extends AbstractResetPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ResetPasswordCommand.class);

	public ResetPasswordCommand(IResetPasswordWithNewPasswordData actionData, DatabaseHandle databaseHandle, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(actionData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IResetPasswordModel model = daoProvider.getResetPasswordDao().selectByToken(getHandle(), commandData.getToken());
		if (model == null) {
			throwBadRequest("tokenDoesNotExist");
		}
		this.commandData.setUserId(model.getUserId());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
