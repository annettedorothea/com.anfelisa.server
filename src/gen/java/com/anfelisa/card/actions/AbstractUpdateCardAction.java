/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.actions;

import java.time.LocalDateTime;

import de.acegen.Data;
import de.acegen.CustomAppConfiguration;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.SquishyDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.card.commands.UpdateCardCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractUpdateCardAction extends WriteAction<com.anfelisa.card.models.CardUpdateModel> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractUpdateCardAction.class);

	public AbstractUpdateCardAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.actions.UpdateCardAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<com.anfelisa.card.models.CardUpdateModel> getCommand() {
		return new UpdateCardCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected Data<com.anfelisa.card.models.CardUpdateModel> initActionDataFromSquishyDataProvider(Data<com.anfelisa.card.models.CardUpdateModel> data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public Data<com.anfelisa.card.models.CardUpdateModel> initActionData(Data<com.anfelisa.card.models.CardUpdateModel> data) {
		return data;
	}

}




/******* S.D.G. *******/



