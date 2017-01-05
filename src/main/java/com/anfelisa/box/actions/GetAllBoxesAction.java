package com.anfelisa.box.actions;

import com.anfelisa.ace.DatabaseHandle;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.AllBoxesData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;

public class GetAllBoxesAction extends AbstractGetAllBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllBoxesAction.class);

	public GetAllBoxesAction(AllBoxesData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		List<IBoxModel> allBoxes = BoxDao.selectAll(this.getDatabaseHandle().getHandle(), this.actionData.getSchema());
		this.actionData.setBoxList(allBoxes);
	}

}

/*       S.D.G.       */
