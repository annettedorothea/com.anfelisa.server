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

import com.anfelisa.box.commands.ScoreReinforceCardCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractScoreReinforceCardAction extends WriteAction<com.anfelisa.box.models.ScoreReinforceCardModel> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractScoreReinforceCardAction.class);

	public AbstractScoreReinforceCardAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.ScoreReinforceCardAction", persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand<com.anfelisa.box.models.ScoreReinforceCardModel> getCommand() {
		return new ScoreReinforceCardCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected Data<com.anfelisa.box.models.ScoreReinforceCardModel> initActionDataFromSquishyDataProvider(Data<com.anfelisa.box.models.ScoreReinforceCardModel> data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public Data<com.anfelisa.box.models.ScoreReinforceCardModel> initActionData(Data<com.anfelisa.box.models.ScoreReinforceCardModel> data) {
		return data;
	}

}




/******* S.D.G. *******/



