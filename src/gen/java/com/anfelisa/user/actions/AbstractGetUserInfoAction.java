/********************************************************************************
 * generated by de.acegen 1.5.6
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
import de.acegen.SquishyDataProvider;

import com.anfelisa.user.data.IUserInfoData;
import com.anfelisa.user.data.UserInfoData;

@SuppressWarnings("unused")
public abstract class AbstractGetUserInfoAction extends ReadAction<IUserInfoData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetUserInfoAction.class);
	
	public AbstractGetUserInfoAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.GetUserInfoAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	protected abstract IUserInfoData loadDataForGetRequest(IUserInfoData data, PersistenceHandle readonlyHandle);

	@Override
	protected IUserInfoData initActionDataFromSquishyDataProvider(IUserInfoData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public IUserInfoData initActionData(IUserInfoData data) {
		return data;
	}

}



/******* S.D.G. *******/



