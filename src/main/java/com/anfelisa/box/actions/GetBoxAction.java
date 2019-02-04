package com.anfelisa.box.actions;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IBoxViewModel;

public class GetBoxAction extends AbstractGetBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxAction.class);

	public GetBoxAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest(Handle readonlyHandle) {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, actionData.getBoxId());
		if (box == null) {
			throwBadRequest("box does not exist");
		}
		if (!box.getUserId().equals(actionData.getUserId())) {
			throwUnauthorized();
		}
		IBoxViewModel boxInfo = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, actionData.getBoxId(),
				actionData.getToday());
		this.actionData.mapFrom(boxInfo);
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
