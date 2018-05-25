package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.BoxUpdateData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;

public class UpdateBoxCommand extends AbstractUpdateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxCommand.class);

	private BoxDao boxDao = new BoxDao();

	public UpdateBoxCommand(BoxUpdateData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = boxDao.selectByBoxId(this.getHandle(), commandData.getBoxId());
		/*if (!AuthUser.ADMIN.equals(commandData.getCredentialsRole())
				&& !box.getUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}*/
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
