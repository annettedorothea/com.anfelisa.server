/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.box.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.BoxModel;
import com.anfelisa.box.models.BoxSettingsModel;
import com.anfelisa.box.models.BoxSettingsWrapperModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetBoxSettingsAction extends AbstractGetBoxSettingsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxSettingsAction.class);

	public GetBoxSettingsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	protected Data<BoxSettingsWrapperModel> loadDataForGetRequest(Data<BoxSettingsWrapperModel> data,
			PersistenceHandle readonlyHandle) {
		BoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, data.getModel().getBoxId());
		if (!box.getUserId().equals(data.getModel().getUserId())) {
			throwSecurityException();
		}
		BoxSettingsModel settings = this.daoProvider.getBoxDao().selectSettingsByBoxId(readonlyHandle,
				data.getModel().getBoxId());
		data.getModel().setBoxSettings(settings);
		return data;
	}

}

/******* S.D.G. *******/
