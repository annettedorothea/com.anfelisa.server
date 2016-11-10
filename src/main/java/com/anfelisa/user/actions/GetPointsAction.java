package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.PointsData;
import com.anfelisa.user.models.CustomUserDao;

public class GetPointsAction extends AbstractGetPointsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetPointsAction.class);

	public GetPointsAction(PointsData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		int boxPoints = CustomUserDao.selectBoxPoints(this.getDatabaseHandle().getHandle(), this.actionData.getUsername(), this.actionData.getSchema());
		int testPoints = CustomUserDao.selectTestPoints(this.getDatabaseHandle().getHandle(), this.actionData.getUsername(), this.actionData.getSchema());
		this.actionData.setPoints(boxPoints + testPoints);
	}

}

/*       S.D.G.       */
