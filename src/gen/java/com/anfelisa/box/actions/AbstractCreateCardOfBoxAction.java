package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.CardOfBoxCreationData;

import com.anfelisa.box.commands.CreateCardOfBoxCommand;

public abstract class AbstractCreateCardOfBoxAction extends Action<CardOfBoxCreationData> {

	public AbstractCreateCardOfBoxAction(CardOfBoxCreationData actionParam, DatabaseHandle databaseHandle) {
		super("CreateCardOfBoxAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new CreateCardOfBoxCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
