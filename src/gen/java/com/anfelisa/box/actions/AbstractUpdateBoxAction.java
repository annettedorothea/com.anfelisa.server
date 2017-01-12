package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxCreationData;

import com.anfelisa.box.commands.UpdateBoxCommand;

public abstract class AbstractUpdateBoxAction extends Action<BoxCreationData> {

	public AbstractUpdateBoxAction(DBI jdbi) {
		super("UpdateBoxAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateBoxCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
