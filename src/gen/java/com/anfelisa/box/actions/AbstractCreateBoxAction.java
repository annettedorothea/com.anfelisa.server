/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.actions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import de.acegen.CustomAppConfiguration;
import de.acegen.HttpMethod;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ITimelineItem;
import de.acegen.ViewProvider;
import de.acegen.SquishyDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.box.data.IBoxCreationData;
import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.commands.CreateBoxCommand;

@SuppressWarnings("unused")
public abstract class AbstractCreateBoxAction extends WriteAction<IBoxCreationData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateBoxAction.class);
	
	public AbstractCreateBoxAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.CreateBoxAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand<IBoxCreationData> getCommand() {
		return new CreateBoxCommand(daoProvider, viewProvider, this.appConfiguration);
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



