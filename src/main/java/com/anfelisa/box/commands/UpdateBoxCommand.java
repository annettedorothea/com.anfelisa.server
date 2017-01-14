package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;

public class UpdateBoxCommand extends AbstractUpdateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxCommand.class);

	public UpdateBoxCommand(BoxCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = BoxDao.selectByBoxId(this.getHandle(), commandData.getBoxId(), commandData.getSchema());
		if (!box.getUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		this.outcome = created;
	}

}

/*       S.D.G.       */
