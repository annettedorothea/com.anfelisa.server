package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScoreReinforceCardData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IReinforceCardModel;

public class ScoreReinforceCardCommand extends AbstractScoreReinforceCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScoreReinforceCardCommand.class);

	public ScoreReinforceCardCommand(ScoreReinforceCardData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IReinforceCardModel reinforceCard = daoProvider.getReinforceCardDao().selectByReinforceCardId(getHandle(), commandData.getReinforceCardId());
		if (reinforceCard == null) {
			throwBadRequest("card does not exist");
		}
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(this.getHandle(), reinforceCard.getBoxId());
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
