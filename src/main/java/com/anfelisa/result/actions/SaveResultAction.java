package com.anfelisa.result.actions;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.result.data.ResultSaveData;

public class SaveResultAction extends AbstractSaveResultAction {

	static final Logger LOG = LoggerFactory.getLogger(SaveResultAction.class);

	public SaveResultAction(ResultSaveData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		this.actionData.setDate(new DateTime(System.currentTimeMillis()));
		List<Integer> boxIds = CustomBoxDao.selectBoxIdsForAddCardsAfterEdit(this.getDatabaseHandle().getHandle(), this.actionData.getSchema(),
				this.actionData.getTestId(), this.actionData.getUsername());
		this.actionData.setBoxIds(boxIds);
	}

}

/* S.D.G. */
