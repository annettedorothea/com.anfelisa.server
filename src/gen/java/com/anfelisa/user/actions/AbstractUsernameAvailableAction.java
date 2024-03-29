/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.actions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.Data;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ReadAction;
import de.acegen.SquishyDataProvider;

public abstract class AbstractUsernameAvailableAction extends ReadAction<com.anfelisa.user.models.UsernameAvailableModel> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractUsernameAvailableAction.class);
	
	public AbstractUsernameAvailableAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.UsernameAvailableAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	protected abstract Data<com.anfelisa.user.models.UsernameAvailableModel> loadDataForGetRequest(Data<com.anfelisa.user.models.UsernameAvailableModel> data, PersistenceHandle readonlyHandle);

	@Override
	protected Data<com.anfelisa.user.models.UsernameAvailableModel> initActionDataFromSquishyDataProvider(Data<com.anfelisa.user.models.UsernameAvailableModel> data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public Data<com.anfelisa.user.models.UsernameAvailableModel> initActionData(Data<com.anfelisa.user.models.UsernameAvailableModel> data) {
		return data;
	}

}



/******* S.D.G. *******/



