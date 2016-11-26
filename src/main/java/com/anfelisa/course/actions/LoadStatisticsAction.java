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
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		DateTime startDate = new DateTime(this.actionParam.getYear(), this.actionParam.getMonth(), 1, 0, 0, 0);
		DateTime endDate = startDate.plusMonths(1);
		List<IStatisticsItemModel> itemList = CustomStatisticsDao.selectStatistics(this.getDatabaseHandle().getHandle(), this.actionParam.getUsername(), startDate, endDate, this.actionParam.getSchema());
		this.actionData.setStatisticsItemList(itemList);
		int points = 0;
		int maxPoints = 0;
		for (IStatisticsItemModel item : itemList) {
			points += item.getPoints();
			maxPoints += item.getMaxPoints();
		}
		this.actionData.setMaxPoints(maxPoints);
		this.actionData.setPoints(points);
		this.actionData.setRate(points * 100 / maxPoints);
	}

}

/*       S.D.G.       */
