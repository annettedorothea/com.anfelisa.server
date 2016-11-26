package com.anfelisa.box.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxListData;
import com.anfelisa.box.models.CustomBoxDao;

public class LoadBoxesAction extends AbstractLoadBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxesAction.class);

	public LoadBoxesAction(BoxListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		this.actionData.setBoxList(CustomBoxDao.selectByUsername(this.getDatabaseHandle().getHandle(),
				this.actionParam.getSchema(), this.actionParam.getUsername()));
	}

}

/* S.D.G. */
