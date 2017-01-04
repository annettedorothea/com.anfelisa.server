package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.CardCreationData;

import com.anfelisa.box.commands.ImportCardCommand;

public abstract class AbstractImportCardAction extends Action<CardCreationData> {

	public AbstractImportCardAction(CardCreationData actionParam, DatabaseHandle databaseHandle) {
		super("ImportCardAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new ImportCardCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
