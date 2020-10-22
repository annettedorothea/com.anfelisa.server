/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.user.actions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ViewProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ReadAction;
import de.acegen.ITimelineItem;
import de.acegen.NonDeterministicDataProvider;

import de.acegen.auth.AuthUser;

import com.anfelisa.user.data.IUserData;
import com.anfelisa.user.data.UserData;

@SuppressWarnings("unused")
public abstract class AbstractGetUserProfileAction extends ReadAction<IUserData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetUserProfileAction.class);
	
	public AbstractGetUserProfileAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.GetUserProfileAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);

	@Override
	protected void initActionDataFromNonDeterministicDataProvider() {
		LocalDateTime systemTime = NonDeterministicDataProvider.consumeSystemTime(this.actionData.getUuid());
		if (systemTime != null) {
			this.actionData.setSystemTime(systemTime);
		}
	}

}



/******* S.D.G. *******/



