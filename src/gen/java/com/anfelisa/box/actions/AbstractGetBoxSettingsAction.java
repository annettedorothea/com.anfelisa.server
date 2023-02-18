/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.actions;

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

public abstract class AbstractGetBoxSettingsAction extends ReadAction<com.anfelisa.box.models.BoxSettingsWrapperModel> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetBoxSettingsAction.class);
	
	public AbstractGetBoxSettingsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.GetBoxSettingsAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	protected abstract Data<com.anfelisa.box.models.BoxSettingsWrapperModel> loadDataForGetRequest(Data<com.anfelisa.box.models.BoxSettingsWrapperModel> data, PersistenceHandle readonlyHandle);

	@Override
	protected Data<com.anfelisa.box.models.BoxSettingsWrapperModel> initActionDataFromSquishyDataProvider(Data<com.anfelisa.box.models.BoxSettingsWrapperModel> data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public Data<com.anfelisa.box.models.BoxSettingsWrapperModel> initActionData(Data<com.anfelisa.box.models.BoxSettingsWrapperModel> data) {
		return data;
	}

}



/******* S.D.G. *******/



