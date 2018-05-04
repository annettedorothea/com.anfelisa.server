package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.RecalculateScheduledCardsData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;

public class RecalculateScheduledCardsCommand extends AbstractRecalculateScheduledCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(RecalculateScheduledCardsCommand.class);

	private BoxDao boxDao = new BoxDao();

	public RecalculateScheduledCardsCommand(RecalculateScheduledCardsData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = boxDao.selectByBoxId(this.getHandle(), this.commandData.getBoxId());
		if (!box.getUsername().equals(commandData.getUsername())) {
			this.throwUnauthorized();
		}
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
