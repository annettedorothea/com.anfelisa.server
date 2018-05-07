package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.EmailConfirmationData;
import com.anfelisa.user.models.IEmailConfirmationModel;
import com.anfelisa.user.models.IUserModel;

public class ConfirmEmailCommand extends AbstractConfirmEmailCommand {

	static final Logger LOG = LoggerFactory.getLogger(ConfirmEmailCommand.class);

	public ConfirmEmailCommand(EmailConfirmationData commandParam, DatabaseHandle databaseHandle,
			DaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IEmailConfirmationModel emailConfirmation = daoProvider.emailConfirmationDao.selectByToken(getHandle(),
				commandData.getToken());
		if (emailConfirmation == null) {
			throwBadRequest("Token not found.");
		}
		IUserModel user = daoProvider.userDao.selectByUserId(getHandle(), emailConfirmation.getUserId());
		if (user == null) {
			throwBadRequest("User does not exist.");
		}
		this.commandData.setUserId(user.getUserId());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
