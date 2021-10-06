/********************************************************************************
 * generated by de.acegen 1.6.0
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

import com.anfelisa.card.data.IMoveCardsData;
import com.anfelisa.card.commands.MoveCardsCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMoveCardsAction extends WriteAction<IMoveCardsData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractMoveCardsAction.class);

	public AbstractMoveCardsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.actions.MoveCardsAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<IMoveCardsData> getCommand() {
		return new MoveCardsCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected IMoveCardsData initActionDataFromSquishyDataProvider(IMoveCardsData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public IMoveCardsData initActionData(IMoveCardsData data) {
		return data;
	}

}




/******* S.D.G. *******/



