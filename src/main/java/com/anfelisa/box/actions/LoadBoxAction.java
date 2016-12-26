package com.anfelisa.box.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxIdData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;

public class LoadBoxAction extends AbstractLoadBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxAction.class);

	public LoadBoxAction(BoxIdData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		IBoxModel box = BoxDao.selectByBoxId(this.getDatabaseHandle().getHandle(), this.actionData.getBoxId(), this.actionData.getSchema());
		this.actionData.setName(box.getName());
		this.actionData.setUsername(box.getUsername());
	}

}

/*       S.D.G.       */
