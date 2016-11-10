package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.PointsData;


public abstract class AbstractGetPointsAction extends Action<PointsData> {

	public AbstractGetPointsAction(PointsData actionParam, DatabaseHandle databaseHandle) {
		super("GetPointsAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
