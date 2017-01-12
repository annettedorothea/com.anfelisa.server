package com.anfelisa.result.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.result.data.MyResultData;


public abstract class AbstractLoadResultAction extends Action<MyResultData> {

	public AbstractLoadResultAction(DBI jdbi) {
		super("LoadResultAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
