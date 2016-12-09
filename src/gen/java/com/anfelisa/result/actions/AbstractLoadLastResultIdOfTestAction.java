package com.anfelisa.result.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.result.data.LastResultIdData;


public abstract class AbstractLoadLastResultIdOfTestAction extends Action<LastResultIdData> {

	public AbstractLoadLastResultIdOfTestAction(LastResultIdData actionParam, DatabaseHandle databaseHandle) {
		super("LoadLastResultIdOfTestAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
