/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.card.actions;

import java.time.LocalDateTime;

import de.acegen.CustomAppConfiguration;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.SquishyDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.card.data.ICardDeleteData;
import com.anfelisa.card.commands.DeleteCardCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDeleteCardAction extends WriteAction<ICardDeleteData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteCardAction.class);

	public AbstractDeleteCardAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.actions.DeleteCardAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<ICardDeleteData> getCommand() {
		return new DeleteCardCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected ICardDeleteData initActionDataFromSquishyDataProvider(ICardDeleteData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public ICardDeleteData initActionData(ICardDeleteData data) {
		return data;
	}

}




/******* S.D.G. *******/



