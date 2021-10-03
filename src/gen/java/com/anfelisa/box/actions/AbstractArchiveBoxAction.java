/********************************************************************************
 * generated by de.acegen 1.5.4
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

import com.anfelisa.box.data.IBoxArchiveData;
import com.anfelisa.box.data.BoxArchiveData;
import com.anfelisa.box.commands.ArchiveBoxCommand;

@SuppressWarnings("unused")
public abstract class AbstractArchiveBoxAction extends WriteAction<IBoxArchiveData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractArchiveBoxAction.class);
	
	public AbstractArchiveBoxAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.ArchiveBoxAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand<IBoxArchiveData> getCommand() {
		return new ArchiveBoxCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected IBoxArchiveData initActionDataFromSquishyDataProvider(IBoxArchiveData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public IBoxArchiveData initActionData(IBoxArchiveData data) {
		return data;
	}

}




/******* S.D.G. *******/



