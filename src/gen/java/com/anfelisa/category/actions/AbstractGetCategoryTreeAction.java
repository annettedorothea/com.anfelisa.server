/********************************************************************************
 * generated by de.acegen 1.0.2
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
import de.acegen.NonDeterministicDataProvider;

import com.anfelisa.category.data.ICategoryTreeData;
import com.anfelisa.category.data.CategoryTreeData;

@SuppressWarnings("unused")
public abstract class AbstractGetCategoryTreeAction extends ReadAction<ICategoryTreeData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetCategoryTreeAction.class);
	
	public AbstractGetCategoryTreeAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.GetCategoryTreeAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
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



