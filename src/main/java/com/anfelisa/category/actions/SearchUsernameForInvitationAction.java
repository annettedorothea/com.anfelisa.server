/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.category.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.models.UserAccessToCategoryModel;
import com.anfelisa.category.models.UsernameSearchModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class SearchUsernameForInvitationAction extends AbstractSearchUsernameForInvitationAction {

	static final Logger LOG = LoggerFactory.getLogger(SearchUsernameForInvitationAction.class);

	public SearchUsernameForInvitationAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, 
			ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}


	@Override
	protected Data<UsernameSearchModel> loadDataForGetRequest(Data<UsernameSearchModel> data, PersistenceHandle readonlyHandle) {
		UserAccessToCategoryModel access = daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(readonlyHandle, data.getModel().getCategoryId(), data.getModel().getUserId());
		if (access == null || !access.getEditable()) {
			throwSecurityException();
		}
		List<String> usernames = daoProvider.getCategoryDao().search(readonlyHandle, data.getModel().getUsernameSearchString(), data.getModel().getCategoryId());
		data.getModel().setUsernames(usernames);
		return data;
	}
	

}



/******* S.D.G. *******/



