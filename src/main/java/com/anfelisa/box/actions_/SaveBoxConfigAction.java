package com.anfelisa.box.actions_;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.actions.AbstractSaveBoxConfigAction;
import com.anfelisa.box.data.BoxConfigData;
import com.anfelisa.box.models.CustomBoxOfCourseDao;
import com.anfelisa.box.models.IBoxOfCourseModel;

public class SaveBoxConfigAction extends AbstractSaveBoxConfigAction {

	static final Logger LOG = LoggerFactory.getLogger(SaveBoxConfigAction.class);

	public SaveBoxConfigAction(BoxConfigData actionParam, DatabaseHandle databaseHandle) {
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
		List<IBoxOfCourseModel> list = this.actionData.getBoxOfCourseList();
		this.actionData.setExistingItems(new ArrayList<IBoxOfCourseModel>());
		for (IBoxOfCourseModel item : list) {
			IBoxOfCourseModel existingItem = CustomBoxOfCourseDao.select(this.getDatabaseHandle().getHandle(),
					this.actionData.getSchema(), item.getBoxId(), item.getCourseId());
			this.actionData.getExistingItems().add(existingItem);
		}
	}

}

/* S.D.G. */
