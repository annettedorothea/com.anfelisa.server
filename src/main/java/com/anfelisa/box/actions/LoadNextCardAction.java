package com.anfelisa.box.actions;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.INextCardModel;

public class LoadNextCardAction extends AbstractLoadNextCardAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextCardAction.class);

	public LoadNextCardAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
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

		INextCardModel nextCard = daoProvider.getScheduledCardDao().selectFirstScheduledCard(getHandle(),
				actionData.getBoxId(), actionData.getToday());
		if (nextCard != null) {
			this.actionData.setRootCategoryId(box.getCategoryId());
			this.actionData.setCategoryId(nextCard.getCategoryId());
			this.actionData.setGiven(nextCard.getGiven());
			this.actionData.setImage(nextCard.getImage());
			this.actionData.setLastQuality(nextCard.getLastQuality());
			this.actionData.setScheduledDate(nextCard.getScheduledDate());
			this.actionData.setWanted(nextCard.getWanted());
			this.actionData.setScheduledCardId(nextCard.getScheduledCardId());
			this.actionData.setCardId(nextCard.getCardId());
			this.actionData.setCount(nextCard.getCount());
			this.actionData.setScoredDate(nextCard.getScoredDate());
		}
	}

}

/*       S.D.G.       */
