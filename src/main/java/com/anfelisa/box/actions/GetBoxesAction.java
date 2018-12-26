package com.anfelisa.box.actions;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxInfoModel;

public class GetBoxesAction extends AbstractGetBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxesAction.class);

	public GetBoxesAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest() {
		List<IBoxInfoModel> boxList = this.daoProvider.getCustomBoxDao().selectByUserId(
				this.getDatabaseHandle().getHandle(), this.actionData.getUserId(), actionData.getToday());
		this.actionData.setBoxList(boxList);
	}

}

/*       S.D.G.       */
