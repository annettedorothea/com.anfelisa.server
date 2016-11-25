package com.anfelisa.course.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.StatisticsData;


public abstract class AbstractLoadStatisticsAction extends Action<StatisticsData> {

	public AbstractLoadStatisticsAction(StatisticsData actionParam, DatabaseHandle databaseHandle) {
		super("LoadStatisticsAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
