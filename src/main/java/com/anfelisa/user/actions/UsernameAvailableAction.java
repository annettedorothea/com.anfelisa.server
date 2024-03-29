/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.models.UsernameAvailableModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class UsernameAvailableAction extends AbstractUsernameAvailableAction {

	static final Logger LOG = LoggerFactory.getLogger(UsernameAvailableAction.class);

	public UsernameAvailableAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	protected Data<UsernameAvailableModel> loadDataForGetRequest(Data<UsernameAvailableModel> data,
			PersistenceHandle readonlyHandle) {
		if (daoProvider.getUserDao().selectByUsername(readonlyHandle,
				data.getModel().getUsername()) == null) {
			data.getModel().setAvailable(true);
		} else {
			data.getModel().setAvailable(false);
		}
		return data;
	}

}

/******* S.D.G. *******/
