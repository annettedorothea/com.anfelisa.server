package com.anfelisa.card.actions;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class GetCardsAction extends AbstractGetCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsAction.class);

	public GetCardsAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest() {
		IUserAccessToCategoryModel userAccessToCategoryModel = daoProvider.getUserAccessToCategoryDao().hasUserAccessTo(getHandle(), actionData.getCategoryId(), actionData.getUserId());
		if (userAccessToCategoryModel == null) {
			throwBadRequest();
		}
		List<ICardModel> cardList = daoProvider.getCardDao().selectAllOfCategory(getHandle(), actionData.getCategoryId());
		this.actionData.setCardList(cardList);
	}

}

/*       S.D.G.       */
