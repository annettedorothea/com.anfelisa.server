/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.actions;

import java.time.LocalDateTime;

import de.acegen.Data;
import de.acegen.CustomAppConfiguration;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.SquishyDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.category.commands.ToggleCategoryOrderCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractToggleCategoryOrderAction extends WriteAction<com.anfelisa.category.models.ToggleCategoryOrderModel> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractToggleCategoryOrderAction.class);

	public AbstractToggleCategoryOrderAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.ToggleCategoryOrderAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<com.anfelisa.category.models.ToggleCategoryOrderModel> getCommand() {
		return new ToggleCategoryOrderCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected Data<com.anfelisa.category.models.ToggleCategoryOrderModel> initActionDataFromSquishyDataProvider(Data<com.anfelisa.category.models.ToggleCategoryOrderModel> data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public Data<com.anfelisa.category.models.ToggleCategoryOrderModel> initActionData(Data<com.anfelisa.category.models.ToggleCategoryOrderModel> data) {
		return data;
	}

}




/******* S.D.G. *******/


