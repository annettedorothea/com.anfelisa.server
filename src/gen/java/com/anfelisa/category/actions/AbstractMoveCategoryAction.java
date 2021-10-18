/********************************************************************************
 * generated by de.acegen 1.6.4
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

import com.anfelisa.category.data.ICategoryMoveData;
import com.anfelisa.category.commands.MoveCategoryCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMoveCategoryAction extends WriteAction<ICategoryMoveData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractMoveCategoryAction.class);

	public AbstractMoveCategoryAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.MoveCategoryAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<ICategoryMoveData> getCommand() {
		return new MoveCategoryCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected ICategoryMoveData initActionDataFromSquishyDataProvider(ICategoryMoveData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public ICategoryMoveData initActionData(ICategoryMoveData data) {
		return data;
	}

}




/******* S.D.G. *******/



