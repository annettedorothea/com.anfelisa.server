/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.actions;

import java.time.LocalDateTime;

import de.acegen.Data;
import de.acegen.CustomAppConfiguration;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.SquishyDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.box.commands.CreateReverseBoxCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractCreateReverseBoxAction extends WriteAction<com.anfelisa.box.models.BoxCreationModel> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateReverseBoxAction.class);

	public AbstractCreateReverseBoxAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.CreateReverseBoxAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<com.anfelisa.box.models.BoxCreationModel> getCommand() {
		return new CreateReverseBoxCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected Data<com.anfelisa.box.models.BoxCreationModel> initActionDataFromSquishyDataProvider(Data<com.anfelisa.box.models.BoxCreationModel> data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public Data<com.anfelisa.box.models.BoxCreationModel> initActionData(Data<com.anfelisa.box.models.BoxCreationModel> data) {
		return data;
	}

}




/******* S.D.G. *******/



