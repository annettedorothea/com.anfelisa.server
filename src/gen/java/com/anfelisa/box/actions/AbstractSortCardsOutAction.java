/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.actions;

import java.time.LocalDateTime;

import de.acegen.CustomAppConfiguration;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.SquishyDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.box.data.ISortCardsOutData;
import com.anfelisa.box.commands.SortCardsOutCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSortCardsOutAction extends WriteAction<ISortCardsOutData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractSortCardsOutAction.class);

	public AbstractSortCardsOutAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.SortCardsOutAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<ISortCardsOutData> getCommand() {
		return new SortCardsOutCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected ISortCardsOutData initActionDataFromSquishyDataProvider(ISortCardsOutData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public ISortCardsOutData initActionData(ISortCardsOutData data) {
		return data;
	}

}




/******* S.D.G. *******/



