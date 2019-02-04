package com.anfelisa.box.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.IScoreReinforceCardData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IReinforceCardModel;

public class ScoreReinforceCardCommand extends AbstractScoreReinforceCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScoreReinforceCardCommand.class);

	public ScoreReinforceCardCommand(IScoreReinforceCardData actionData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		IReinforceCardModel reinforceCard = daoProvider.getReinforceCardDao().selectByReinforceCardId(readonlyHandle,  commandData.getReinforceCardId());
		if (reinforceCard == null) {
			throwBadRequest("cardDoesNotExist");
		}
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, reinforceCard.getBoxId());
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwUnauthorized();
		}
		if (commandData.getQuality() >= 4) {
			this.commandData.setOutcome(remove);
		} else {
			this.commandData.setChangeDate(commandData.getSystemTime());
			this.commandData.setOutcome(keep);
		}
	}

}

/*       S.D.G.       */
