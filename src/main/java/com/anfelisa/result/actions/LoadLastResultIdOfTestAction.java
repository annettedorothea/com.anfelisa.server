package com.anfelisa.result.actions;

import com.anfelisa.ace.DatabaseHandle;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.result.data.LastResultIdData;
import com.anfelisa.result.models.CustomResultDao;
import com.anfelisa.result.models.IResultAbstractModel;

public class LoadLastResultIdOfTestAction extends AbstractLoadLastResultIdOfTestAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadLastResultIdOfTestAction.class);

	public LoadLastResultIdOfTestAction(LastResultIdData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		List<IResultAbstractModel> results = CustomResultDao.selectByTestIdAndUsername(this.databaseHandle.getHandle(),
				this.actionParam.getSchema(), this.actionParam.getTestId(), this.actionParam.getUsername());
		if (results != null && results.size() > 0) {
			this.actionData.setResultId(results.get(results.size() - 1).getResultId());
		}
	}

}

/* S.D.G. */
