package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxIdListData;

import com.anfelisa.box.commands.FillBoxWithCardsCommand;

public abstract class AbstractFillBoxWithCardsAction extends Action<BoxIdListData> {

	public AbstractFillBoxWithCardsAction(BoxIdListData actionParam, DatabaseHandle databaseHandle) {
		super("FillBoxWithCardsAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new FillBoxWithCardsCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
