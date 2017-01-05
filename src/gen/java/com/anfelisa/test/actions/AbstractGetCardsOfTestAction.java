package com.anfelisa.test.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.CardContentHashListData;


public abstract class AbstractGetCardsOfTestAction extends Action<CardContentHashListData> {

	public AbstractGetCardsOfTestAction(CardContentHashListData actionParam, DatabaseHandle databaseHandle) {
		super("GetCardsOfTestAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
