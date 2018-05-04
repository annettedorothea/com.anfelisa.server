package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;

public class UpdateBoxCommand extends AbstractUpdateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxCommand.class);

	private BoxDao boxDao = new BoxDao();

	public UpdateBoxCommand(BoxCreationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = boxDao.selectByBoxId(this.getHandle(), commandData.getBoxId());
		if (!box.getUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		this.commandData.setOutcome(updated);
	}

}

/* S.D.G. */
