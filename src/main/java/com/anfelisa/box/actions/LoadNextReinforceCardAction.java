package com.anfelisa.box.actions;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.INextReinforceCardViewModel;

public class LoadNextReinforceCardAction extends AbstractLoadNextReinforceCardAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextReinforceCardAction.class);

	public LoadNextReinforceCardAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
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

		INextReinforceCardViewModel nextCard = daoProvider.getReinforceCardDao().selectFirstScheduledCard(readonlyHandle,
				actionData.getBoxId());
		if (nextCard != null) {
			this.actionData.mapFrom(nextCard);
		}
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
