package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.EmailConfirmationData;
import com.anfelisa.user.models.IEmailConfirmationModel;
import com.anfelisa.user.models.IUserModel;

public class ConfirmEmailCommand extends AbstractConfirmEmailCommand {

	static final Logger LOG = LoggerFactory.getLogger(ConfirmEmailCommand.class);

	public ConfirmEmailCommand(EmailConfirmationData commandParam, DatabaseHandle databaseHandle,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IUserModel user = daoProvider.getUserDao().selectByUsername(getHandle(), commandData.getUsername());
		if (user == null) {
			throwBadRequest("userDoesNotExist");
		}
		if (user.getEmailConfirmed()) {
			this.commandData.setOutcome(alreadyConfirmed);
		} else {
			IEmailConfirmationModel emailConfirmation = daoProvider.getEmailConfirmationDao().selectByToken(getHandle(),
					commandData.getToken());
			if (emailConfirmation == null) {
				throwBadRequest("confirmationTokenDoesNotExist");
			}
			if (!user.getUserId().equals(emailConfirmation.getUserId())) {
				throwBadRequest("tokenDoesNotMatch");
			}
			this.commandData.setUserId(user.getUserId());
			this.commandData.setOutcome(ok);
		}
	}

}

/* S.D.G. */
