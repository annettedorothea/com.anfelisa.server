package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.CardIdData;

import com.anfelisa.box.commands.DeleteCardCommand;

public abstract class AbstractDeleteCardAction extends Action<CardIdData> {

	public AbstractDeleteCardAction(CardIdData actionParam, DatabaseHandle databaseHandle) {
		super("DeleteCardAction", HttpMethod.DELETE, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteCardCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
