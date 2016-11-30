package com.anfelisa.result.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.result.data.MyResultData;


public abstract class AbstractLoadResultAction extends Action<MyResultData> {

	public AbstractLoadResultAction(MyResultData actionParam, DatabaseHandle databaseHandle) {
		super("LoadResultAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
