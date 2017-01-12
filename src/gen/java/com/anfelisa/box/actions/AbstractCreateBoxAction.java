package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxCreationData;

import com.anfelisa.box.commands.CreateBoxCommand;

public abstract class AbstractCreateBoxAction extends Action<BoxCreationData> {

	public AbstractCreateBoxAction(DBI jdbi) {
		super("CreateBoxAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateBoxCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
