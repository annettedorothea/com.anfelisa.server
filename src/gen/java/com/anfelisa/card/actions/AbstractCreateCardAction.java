/********************************************************************************
 * generated by de.acegen
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

import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.card.commands.CreateCardCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractCreateCardAction extends WriteAction<ICardCreationData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateCardAction.class);

	public AbstractCreateCardAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.actions.CreateCardAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<ICardCreationData> getCommand() {
		return new CreateCardCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected ICardCreationData initActionDataFromSquishyDataProvider(ICardCreationData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public ICardCreationData initActionData(ICardCreationData data) {
		return data;
	}

}




/******* S.D.G. *******/



