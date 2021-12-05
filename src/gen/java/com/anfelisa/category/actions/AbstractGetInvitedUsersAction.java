/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.actions;

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
import de.acegen.SquishyDataProvider;

import com.anfelisa.category.data.IAlreadyInvitedUsernamesData;
import com.anfelisa.category.data.AlreadyInvitedUsernamesData;

@SuppressWarnings("unused")
public abstract class AbstractGetInvitedUsersAction extends ReadAction<IAlreadyInvitedUsernamesData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetInvitedUsersAction.class);
	
	public AbstractGetInvitedUsersAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.GetInvitedUsersAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	protected abstract IAlreadyInvitedUsernamesData loadDataForGetRequest(IAlreadyInvitedUsernamesData data, PersistenceHandle readonlyHandle);

	@Override
	protected IAlreadyInvitedUsernamesData initActionDataFromSquishyDataProvider(IAlreadyInvitedUsernamesData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public IAlreadyInvitedUsernamesData initActionData(IAlreadyInvitedUsernamesData data) {
		return data;
	}

}



/******* S.D.G. *******/



