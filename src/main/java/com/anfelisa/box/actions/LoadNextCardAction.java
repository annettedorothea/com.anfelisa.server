package com.anfelisa.box.actions;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.INextCardViewModel;
import com.anfelisa.box.models.ITodaysCardsStatusModel;

public class LoadNextCardAction extends AbstractLoadNextCardAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextCardAction.class);

	public LoadNextCardAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super(jdbi,appConfiguration, daoProvider, viewProvider, e2e);
	}


	protected final void loadDataForGetRequest(Handle readonlyHandle) {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, actionData.getBoxId());
		if (box == null) {
			throwBadRequest("box does not exist");
		}
		if (!box.getUserId().equals(actionData.getUserId())) {
			throwUnauthorized();
		}

		INextCardViewModel nextCard = daoProvider.getScheduledCardDao().selectFirstScheduledCard(readonlyHandle,
				actionData.getBoxId(), actionData.getToday());
		if (nextCard == null) {
			nextCard = daoProvider.getReinforceCardDao().selectFirstReinforceCard(readonlyHandle,
					actionData.getBoxId());
		}
		if (nextCard != null) {
			this.actionData.mapFrom(nextCard);
		}
		ITodaysCardsStatusModel todaysCardsStatus = daoProvider.getBoxDao().todaysCardsStatus(readonlyHandle, box.getBoxId(), actionData.getToday());
		this.actionData.setAllTodaysCards(todaysCardsStatus.getAllTodaysCards());
		this.actionData.setOpenTodaysCards(todaysCardsStatus.getOpenTodaysCards());
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
