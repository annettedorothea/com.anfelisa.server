package com.anfelisa.mandator.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.ace.IDataContainer;


public abstract class AbstractReadMandatorsAction extends Action<IDataContainer> {

	public AbstractReadMandatorsAction(IDataContainer actionParam, DatabaseHandle databaseHandle) {
		super("ReadMandatorsAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
