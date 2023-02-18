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

import com.anfelisa.category.commands.UpdateCategoryCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractUpdateCategoryAction extends WriteAction<com.anfelisa.category.models.CategoryUpdateModel> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractUpdateCategoryAction.class);

	public AbstractUpdateCategoryAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.UpdateCategoryAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<com.anfelisa.category.models.CategoryUpdateModel> getCommand() {
		return new UpdateCategoryCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected Data<com.anfelisa.category.models.CategoryUpdateModel> initActionDataFromSquishyDataProvider(Data<com.anfelisa.category.models.CategoryUpdateModel> data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public Data<com.anfelisa.category.models.CategoryUpdateModel> initActionData(Data<com.anfelisa.category.models.CategoryUpdateModel> data) {
		return data;
	}

}




/******* S.D.G. *******/



