package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;

public class DeleteBoxCommand extends AbstractDeleteBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteBoxCommand.class);

	private BoxDao boxDao = new BoxDao();

	public DeleteBoxCommand(DeleteBoxData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = boxDao.selectByBoxId(this.getHandle(), this.commandData.getBoxId());
		if (!box.getUsername().equals(commandData.getCredentialsUsername())) {
			this.throwUnauthorized();
		}
		this.commandData.setOutcome(deleted);
	}

}

/* S.D.G. */
