package com.anfelisa.box.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxOfCourseListData;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.ICourseToBoxAdditionModel;

public class LoadBoxOfCourseListAction extends AbstractLoadBoxOfCourseListAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxOfCourseListAction.class);

	public LoadBoxOfCourseListAction(BoxOfCourseListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system
		// time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
		List<ICourseToBoxAdditionModel> list = CustomBoxDao.selectCourseToBoxAdditionList(this.databaseHandle.getHandle(), this.actionData.getSchema(),
				this.actionData.getBoxId(), this.actionData.getUsername());
		this.actionData.setCourseToBoxAdditionList(list);
	}

}

/* S.D.G. */
