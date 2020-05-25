package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;
import com.anfelisa.user.models.IResetPasswordModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ResetPasswordCommand extends AbstractResetPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ResetPasswordCommand.class);

	public ResetPasswordCommand(IResetPasswordWithNewPasswordData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IResetPasswordModel model = daoProvider.getResetPasswordDao().selectByToken(readonlyHandle,  commandData.getToken());
		if (model == null) {
			throwIllegalArgumentException("tokenDoesNotExist");
		}
		this.commandData.setUserId(model.getUserId());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
