package com.anfelisa.box.actions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxListData;
import com.anfelisa.box.models.BoxInfoModel;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IBoxInfoModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ICardOfBoxModel;

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
		List<IBoxModel> boxList = CustomBoxDao.selectByUsername(this.getDatabaseHandle().getHandle(),
				this.actionParam.getSchema(), this.actionParam.getUsername());
		List<IBoxInfoModel> boxInfoList = new ArrayList<IBoxInfoModel>();
		for (IBoxModel boxModel : boxList) {
			List<ICardOfBoxModel> todaysCards = CustomBoxDao.selectCardsOfBoxForToday(
					this.getDatabaseHandle().getHandle(), this.actionParam.getSchema(), boxModel.getBoxId());
			BoxInfoModel boxInfoModel = new BoxInfoModel(todaysCards.size(), (todaysCards.size() > 0));
			boxInfoModel.setBox(boxModel);
			boxInfoList.add(boxInfoModel);
		}
		this.actionData.setBoxList(boxInfoList);
	}

}

/* S.D.G. */
