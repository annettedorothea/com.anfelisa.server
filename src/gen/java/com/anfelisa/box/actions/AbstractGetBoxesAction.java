/********************************************************************************
 * generated by de.acegen 1.5.4
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

import com.anfelisa.box.data.IBoxListData;
import com.anfelisa.box.data.BoxListData;

@SuppressWarnings("unused")
public abstract class AbstractGetBoxesAction extends ReadAction<IBoxListData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetBoxesAction.class);
	
	public AbstractGetBoxesAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.GetBoxesAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	protected abstract IBoxListData loadDataForGetRequest(IBoxListData data, PersistenceHandle readonlyHandle);

	@Override
	protected IBoxListData initActionDataFromSquishyDataProvider(IBoxListData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public IBoxListData initActionData(IBoxListData data) {
		return data;
	}

}



/******* S.D.G. *******/



