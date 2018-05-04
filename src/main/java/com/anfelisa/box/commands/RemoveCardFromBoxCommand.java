package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.RemoveCardFromBoxData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardDao;

public class RemoveCardFromBoxCommand extends AbstractRemoveCardFromBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(RemoveCardFromBoxCommand.class);

	private BoxDao boxDao = new BoxDao();
	
	private ScheduledCardDao scheduledCardDao = new ScheduledCardDao();

	public RemoveCardFromBoxCommand(RemoveCardFromBoxData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		IScheduledCardModel scheduledCard = scheduledCardDao.selectByScheduledCardId(getHandle(), this.commandData.getScheduledCardId());
		if (scheduledCard == null) {
			this.throwBadRequest();
		}
		IBoxModel box = boxDao.selectByBoxId(getHandle(), scheduledCard.getBoxId());
		if (!box.getUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		this.commandData.setOutcome(deleted);
	}

}

/* S.D.G. */
