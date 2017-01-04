package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.ContentHashesOfCreatedCardsData;

import com.anfelisa.box.commands.DeleteObsoleteCardsCommand;

public abstract class AbstractDeleteObsoleteCardsAction extends Action<ContentHashesOfCreatedCardsData> {

	public AbstractDeleteObsoleteCardsAction(ContentHashesOfCreatedCardsData actionParam, DatabaseHandle databaseHandle) {
		super("DeleteObsoleteCardsAction", HttpMethod.DELETE, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteObsoleteCardsCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
