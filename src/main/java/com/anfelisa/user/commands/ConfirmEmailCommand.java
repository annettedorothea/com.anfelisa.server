package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.models.IEmailConfirmationModel;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

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
			throwIllegalArgumentException("userDoesNotExist");
		}
		if (user.getEmailConfirmed()) {
			this.commandData.setOutcome(alreadyConfirmed);
		} else {
			IEmailConfirmationModel emailConfirmation = daoProvider.getEmailConfirmationDao().selectByToken(readonlyHandle, 
					commandData.getToken());
			if (emailConfirmation == null) {
				throwIllegalArgumentException("tokenDoesNotExist");
			}
			if (!user.getUserId().equals(emailConfirmation.getUserId())) {
				throwIllegalArgumentException("tokenDoesNotMatch");
			}
			this.commandData.setUserId(user.getUserId());
			this.commandData.setOutcome(ok);
		}
	}

}

/* S.D.G. */
