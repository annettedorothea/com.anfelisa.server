package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;

public class DeleteBoxCommand extends AbstractDeleteBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteBoxCommand.class);

	private BoxDao boxDao = new BoxDao();

	public DeleteBoxCommand(DeleteBoxData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = boxDao.selectByBoxId(this.getHandle(), this.commandData.getBoxId());
		/*if (!AuthUser.ADMIN.equals(commandData.getCredentialsRole())
				&& !box.getUserId().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}*/
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
