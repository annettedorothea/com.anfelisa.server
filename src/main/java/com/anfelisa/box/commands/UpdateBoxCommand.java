package com.anfelisa.box.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.models.IBoxModel;

public class UpdateBoxCommand extends AbstractUpdateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxCommand.class);

	public UpdateBoxCommand(IBoxUpdateData actionData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(actionData, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, this.commandData.getBoxId());
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwUnauthorized();
		}
		this.commandData.setOutcome(AbstractUpdateBoxCommand.ok); 
	}

}

/*       S.D.G.       */
