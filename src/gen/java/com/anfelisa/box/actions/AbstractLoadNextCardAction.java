/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.box.actions;

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

import com.anfelisa.box.data.INextCardData;
import com.anfelisa.box.data.NextCardData;

@SuppressWarnings("unused")
public abstract class AbstractLoadNextCardAction extends ReadAction<INextCardData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractLoadNextCardAction.class);
	
	public AbstractLoadNextCardAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.LoadNextCardAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	protected abstract INextCardData loadDataForGetRequest(INextCardData data, PersistenceHandle readonlyHandle);

	@Override
	protected INextCardData initActionDataFromSquishyDataProvider(INextCardData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public INextCardData initActionData(INextCardData data) {
		return data;
	}

}



/******* S.D.G. *******/



