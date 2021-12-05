/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.actions;

import java.time.LocalDateTime;

import de.acegen.CustomAppConfiguration;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.SquishyDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.category.data.ICategoryChangeOrderData;
import com.anfelisa.category.commands.ChangeOrderCategoryCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractChangeOrderCategoryAction extends WriteAction<ICategoryChangeOrderData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractChangeOrderCategoryAction.class);

	public AbstractChangeOrderCategoryAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.ChangeOrderCategoryAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<ICategoryChangeOrderData> getCommand() {
		return new ChangeOrderCategoryCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected ICategoryChangeOrderData initActionDataFromSquishyDataProvider(ICategoryChangeOrderData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public ICategoryChangeOrderData initActionData(ICategoryChangeOrderData data) {
		return data;
	}

}




/******* S.D.G. *******/



