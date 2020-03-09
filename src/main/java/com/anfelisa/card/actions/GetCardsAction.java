package com.anfelisa.card.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceConnection;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.card.models.ICardWithInfoModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class GetCardsAction extends AbstractGetCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsAction.class);

	public GetCardsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
	}

	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		IUserAccessToCategoryModel userAccessToCategoryModel = daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, actionData.getCategoryId(), actionData.getUserId());
		if (userAccessToCategoryModel == null) {
			throwBadRequest();
		}
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				actionData.getCategoryId());
		IBoxModel box = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle,
				category.getRootCategoryId(), actionData.getUserId());
		if (box == null) {
			this.actionData.setCardList(
					daoProvider.getCardDao().selectAllOfCategory(readonlyHandle, actionData.getCategoryId()));
		} else {
			List<ICardWithInfoModel> allCards = daoProvider.getCardDao().selectAllOfCategoryWithBoxInfo(readonlyHandle,
					actionData.getCategoryId(), box.getBoxId());
			this.actionData.setCardList(allCards);
		}
	}

	@Override
	public void initActionData() {
	}

}

/* S.D.G. */
