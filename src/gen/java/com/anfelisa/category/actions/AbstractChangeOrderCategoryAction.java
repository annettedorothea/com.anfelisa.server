/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.category.actions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.HttpMethod;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ITimelineItem;
import de.acegen.ViewProvider;
import de.acegen.NotReplayableDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.category.data.ICategoryChangeOrderData;
import com.anfelisa.category.data.CategoryChangeOrderData;
import com.anfelisa.category.commands.ChangeOrderCategoryCommand;

@SuppressWarnings("unused")
public abstract class AbstractChangeOrderCategoryAction extends WriteAction<ICategoryChangeOrderData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractChangeOrderCategoryAction.class);
	
	public AbstractChangeOrderCategoryAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.category.actions.ChangeOrderCategoryAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider, e2e);
	}

	@Override
	public ICommand getCommand() {
		return new ChangeOrderCategoryCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected void initActionDataFrom(ITimelineItem timelineItem) {
		IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
		ICategoryChangeOrderData originalActionData = (ICategoryChangeOrderData)originalData;
		this.actionData.setSystemTime(originalActionData.getSystemTime());
	}


	@Override
	protected void initActionDataFromNotReplayableDataProvider() {
		LocalDateTime systemTime = NotReplayableDataProvider.consumeSystemTime(this.actionData.getUuid());
		if (systemTime != null) {
			this.actionData.setSystemTime(systemTime);
		} else {
			this.actionData.setSystemTime(LocalDateTime.now());
		}
	}

}




/******* S.D.G. *******/



