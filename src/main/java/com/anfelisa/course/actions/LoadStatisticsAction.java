package com.anfelisa.course.actions;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.data.StatisticsData;
import com.anfelisa.course.models.CustomStatisticsDao;
import com.anfelisa.course.models.IStatisticsItemModel;

public class LoadStatisticsAction extends AbstractLoadStatisticsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadStatisticsAction.class);

	public LoadStatisticsAction(StatisticsData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		DateTime startDate = new DateTime(this.actionParam.getYear(), this.actionParam.getMonth(), 1, 0, 0, 0);
		DateTime endDate = startDate.plusMonths(1);
		List<IStatisticsItemModel> model = CustomStatisticsDao.selectStatistics(this.getDatabaseHandle().getHandle(), this.actionParam.getUsername(), startDate, endDate, this.actionParam.getSchema());
		this.actionData.setStatisticsItemList(model);
	}

}

/*       S.D.G.       */
