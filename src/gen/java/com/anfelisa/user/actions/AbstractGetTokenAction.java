/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.user.actions;

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

import com.anfelisa.user.data.ITokenData;
import com.anfelisa.user.data.TokenData;
import com.anfelisa.user.commands.GetTokenCommand;

@SuppressWarnings("unused")
public abstract class AbstractGetTokenAction extends WriteAction<ITokenData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetTokenAction.class);
	
	public AbstractGetTokenAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.GetTokenAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand<ITokenData> getCommand() {
		return new GetTokenCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected ITokenData initActionDataFromSquishyDataProvider(ITokenData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public ITokenData initActionData(ITokenData data) {
		return data;
	}

}




/******* S.D.G. *******/



