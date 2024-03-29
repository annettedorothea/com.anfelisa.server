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

import com.anfelisa.category.commands.MoveCategoryCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMoveCategoryAction extends WriteAction<com.anfelisa.category.models.CategoryMoveModel> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractMoveCategoryAction.class);

	public AbstractMoveCategoryAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.MoveCategoryAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<com.anfelisa.category.models.CategoryMoveModel> getCommand() {
		return new MoveCategoryCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected Data<com.anfelisa.category.models.CategoryMoveModel> initActionDataFromSquishyDataProvider(Data<com.anfelisa.category.models.CategoryMoveModel> data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public Data<com.anfelisa.category.models.CategoryMoveModel> initActionData(Data<com.anfelisa.category.models.CategoryMoveModel> data) {
		return data;
	}

}




/******* S.D.G. *******/



