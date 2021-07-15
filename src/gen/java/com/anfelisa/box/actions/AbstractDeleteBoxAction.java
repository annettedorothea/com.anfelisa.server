/********************************************************************************
 * generated by de.acegen 1.3.0
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

import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.commands.DeleteBoxCommand;

@SuppressWarnings("unused")
public abstract class AbstractDeleteBoxAction extends WriteAction<IDeleteBoxData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteBoxAction.class);
	
	public AbstractDeleteBoxAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.DeleteBoxAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand<IDeleteBoxData> getCommand() {
		return new DeleteBoxCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected IDeleteBoxData initActionDataFromSquishyDataProvider(IDeleteBoxData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public IDeleteBoxData initActionData(IDeleteBoxData data) {
		return data;
	}

}




/******* S.D.G. *******/



