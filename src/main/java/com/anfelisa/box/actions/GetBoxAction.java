package com.anfelisa.box.actions;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxInfoModel;
import com.anfelisa.box.models.IBoxModel;

public class GetBoxAction extends AbstractGetBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxAction.class);

	public GetBoxAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest() {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(getHandle(), actionData.getBoxId());
		if (box == null) {
			throwBadRequest("box does not exist");
		}
		if (!box.getUserId().equals(actionData.getUserId())) {
			throwUnauthorized();
		}
		IBoxInfoModel boxInfo = daoProvider.getCustomBoxDao().selectByBoxId(getHandle(), actionData.getBoxId(),
				actionData.getToday());
		this.actionData.setCategoryName(boxInfo.getCategoryName());
		this.actionData.setDaysBehindSchedule(boxInfo.getDaysBehindSchedule());
		this.actionData.setMaxInterval(boxInfo.getMaxInterval());
		this.actionData.setMyCards(boxInfo.getMyCards());
		this.actionData.setTodaysCards(boxInfo.getTodaysCards());
		this.actionData.setTotalCards(boxInfo.getTotalCards());
		this.actionData.setReinforceCards(boxInfo.getReinforceCards());
		this.actionData.setQuality0Count(boxInfo.getQuality0Count());
		this.actionData.setQuality1Count(boxInfo.getQuality1Count());
		this.actionData.setQuality2Count(boxInfo.getQuality2Count());
		this.actionData.setQuality3Count(boxInfo.getQuality3Count());
		this.actionData.setQuality4Count(boxInfo.getQuality4Count());
		this.actionData.setQuality5Count(boxInfo.getQuality5Count());
	}

}

/*       S.D.G.       */
