package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.CardCreationData;

import com.anfelisa.box.commands.CreateCardCommand;

public abstract class AbstractCreateCardAction extends Action<CardCreationData> {

	public AbstractCreateCardAction(CardCreationData actionParam, DatabaseHandle databaseHandle) {
		super("CreateCardAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new CreateCardCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
