package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.ResetPasswordData;
import com.anfelisa.user.models.IResetPasswordModel;

public class ResetPasswordCommand extends AbstractResetPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ResetPasswordCommand.class);

	public ResetPasswordCommand(ResetPasswordData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IResetPasswordModel model = daoProvider.resetPasswordDao.selectByToken(getHandle(), commandData.getToken());
		if (model == null) {
			throwBadRequest("Token not found.");
		}
		this.commandData.setUserId(model.getUserId());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
