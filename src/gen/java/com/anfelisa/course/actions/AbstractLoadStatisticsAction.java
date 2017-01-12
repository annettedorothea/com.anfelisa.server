package com.anfelisa.course.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.StatisticsData;


public abstract class AbstractLoadStatisticsAction extends Action<StatisticsData> {

	public AbstractLoadStatisticsAction(DBI jdbi) {
		super("LoadStatisticsAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
