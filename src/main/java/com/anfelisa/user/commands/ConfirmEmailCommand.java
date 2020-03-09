package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.models.IEmailConfirmationModel;
import com.anfelisa.user.models.IUserModel;

public class ConfirmEmailCommand extends AbstractConfirmEmailCommand {

	static final Logger LOG = LoggerFactory.getLogger(ConfirmEmailCommand.class);

	public ConfirmEmailCommand(IConfirmEmailData actionData, 
			IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IUserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle,  commandData.getUsername());
		if (user == null) {
			throwBadRequest("userDoesNotExist");
		}
		if (user.getEmailConfirmed()) {
			this.commandData.setOutcome(alreadyConfirmed);
		} else {
			IEmailConfirmationModel emailConfirmation = daoProvider.getEmailConfirmationDao().selectByToken(readonlyHandle, 
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
