package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.models.IBoxModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class DeleteBoxCommand extends AbstractDeleteBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteBoxCommand.class);

	public DeleteBoxCommand(IDeleteBoxData actionData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, this.commandData.getBoxId());
		if (box == null) {
			throwIllegalArgumentException("boxDoesNotExist");
		}
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwSecurityException();
		}
		
		this.commandData.setRootCategoryId(box.getCategoryId());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
