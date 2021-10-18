/********************************************************************************
 * generated by de.acegen 1.6.4
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

import com.anfelisa.box.data.IBoxCreationData;
import com.anfelisa.box.commands.CreateReverseBoxCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractCreateReverseBoxAction extends WriteAction<IBoxCreationData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateReverseBoxAction.class);

	public AbstractCreateReverseBoxAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.CreateReverseBoxAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<IBoxCreationData> getCommand() {
		return new CreateReverseBoxCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected IBoxCreationData initActionDataFromSquishyDataProvider(IBoxCreationData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public IBoxCreationData initActionData(IBoxCreationData data) {
		return data;
	}

}




/******* S.D.G. *******/



