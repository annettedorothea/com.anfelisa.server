package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.CardData;


public abstract class AbstractLoadNextCardAction extends Action<CardData> {

	public AbstractLoadNextCardAction(CardData actionParam, DatabaseHandle databaseHandle) {
		super("LoadNextCardAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
