package com.anfelisa.card.actions;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class GetCardsAction extends AbstractGetCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsAction.class);

	public GetCardsAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider, E2E e2e) {
		super(jdbi, appConfiguration, daoProvider, viewProvider, e2e);
	}

	protected final void loadDataForGetRequest(Handle readonlyHandle) {
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
			this.actionData.setCardList(daoProvider.getCardDao().selectAllOfCategoryWithBoxInfo(readonlyHandle,
					actionData.getCategoryId(), box.getBoxId()));
		}
	}

	@Override
	public void initActionData() {
	}

}

/* S.D.G. */
