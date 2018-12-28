package com.anfelisa.card.actions;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.models.ICardModel;

public class GetDuplicatesAction extends AbstractGetDuplicatesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetDuplicatesAction.class);

	public GetDuplicatesAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest() {
		List<ICardModel> cardList = this.daoProvider.getCardDao().search(getHandle(), actionData.getCategoryId(),
				actionData.getNaturalInputOrder(), actionData.getGiven(), actionData.getWanted());
		this.actionData.setCardList(cardList);
	}

}

/*       S.D.G.       */
