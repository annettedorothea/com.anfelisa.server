/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.models.ForgotPasswordModel;
import com.anfelisa.user.models.UserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ForgotPasswordCommand extends AbstractForgotPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordCommand.class);

	public ForgotPasswordCommand(IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected Data<ForgotPasswordModel> executeCommand(Data<ForgotPasswordModel> data, PersistenceHandle readonlyHandle) {
		UserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle,
				data.getModel().getUsername());
		if (user != null) {
			data.getModel().setEmail(user.getEmail());
			data.getModel().setUserId(user.getUserId());
			this.addOkOutcome(data);
		} else {
			this.addDoesNotExistOutcome(data);
		}
		return data;
	}

}

/******* S.D.G. *******/
