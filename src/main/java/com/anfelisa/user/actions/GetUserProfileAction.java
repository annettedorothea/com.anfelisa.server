/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.user.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.utils.Deletable;
import com.anfelisa.user.data.IProfileUserData;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetUserProfileAction extends AbstractGetUserProfileAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUserProfileAction.class);

	public GetUserProfileAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	protected IProfileUserData loadDataForGetRequest(IProfileUserData data, PersistenceHandle readonlyHandle) {
		IUserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle, data.getUsername());
		data.setEmail(user.getEmail());
		data.setEmailConfirmed(user.getEmailConfirmed());
		List<IBoxModel> boxesOfUser = daoProvider.getBoxDao().selectAllOfUser(readonlyHandle, data.getUserId());
		data.setDeletable(true);
		for (IBoxModel box : boxesOfUser) {
			if (!Deletable.isBoxDeletable(daoProvider, readonlyHandle, box, data.getUserId())) {
				data.setDeletable(false);
			}
		}
		return data;
	}


}

/******* S.D.G. *******/
