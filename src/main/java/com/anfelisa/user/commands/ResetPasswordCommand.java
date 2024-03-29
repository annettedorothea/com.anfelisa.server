/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.models.ResetPasswordModel;
import com.anfelisa.user.models.ResetPasswordWithNewPasswordModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ResetPasswordCommand extends AbstractResetPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ResetPasswordCommand.class);

	public ResetPasswordCommand(IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected Data<ResetPasswordWithNewPasswordModel> executeCommand(Data<ResetPasswordWithNewPasswordModel> data,
			PersistenceHandle readonlyHandle) {
		ResetPasswordModel model = daoProvider.getResetPasswordDao().selectByToken(readonlyHandle,
				data.getModel().getToken());
		if (model == null) {
			throwIllegalArgumentException("tokenDoesNotExist");
		}
		data.getModel().setUserId(model.getUserId());
		this.addOkOutcome(data);
		return data;
	}

}

/******* S.D.G. *******/
