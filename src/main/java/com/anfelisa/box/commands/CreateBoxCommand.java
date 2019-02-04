package com.anfelisa.box.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.IBoxData;

public class CreateBoxCommand extends AbstractCreateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxCommand.class);

	public CreateBoxCommand(IBoxData actionData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(actionData, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		this.commandData.setBoxId(this.commandData.getUuid());
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
