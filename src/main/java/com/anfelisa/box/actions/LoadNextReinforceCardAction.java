package com.anfelisa.box.actions;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.INextReinforceCardModel;

public class LoadNextReinforceCardAction extends AbstractLoadNextReinforceCardAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextReinforceCardAction.class);

	public LoadNextReinforceCardAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
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

		INextReinforceCardModel nextCard = daoProvider.getCustomReinforceCardDao().selectFirstScheduledCard(getHandle(),
				actionData.getBoxId());
		if (nextCard != null) {
			this.actionData.setGiven(nextCard.getGiven());
			this.actionData.setImage(nextCard.getImage());
			this.actionData.setLastQuality(nextCard.getLastQuality());
			this.actionData.setWanted(nextCard.getWanted());
			this.actionData.setChangeDate(nextCard.getChangeDate());
			this.actionData.setReinforceCardId(nextCard.getReinforceCardId());
			this.actionData.setCategoryId(nextCard.getCategoryId());
		}
	}

}

/*       S.D.G.       */
