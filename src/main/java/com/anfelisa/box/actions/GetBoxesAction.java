package com.anfelisa.box.actions;

import java.util.List;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxViewModel;

public class GetBoxesAction extends AbstractGetBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxesAction.class);

	public GetBoxesAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest(Handle readonlyHandle) {
		List<IBoxViewModel> boxList = this.daoProvider.getBoxDao().selectByUserId(readonlyHandle,
				this.actionData.getUserId(), actionData.getToday());
		this.actionData.setBoxList(boxList);
	}

	@Override
	public void initActionData() {
		// TODO Auto-generated method stub

	}

}

/* S.D.G. */
