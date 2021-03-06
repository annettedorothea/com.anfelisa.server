package com.anfelisa.card.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.card.models.ICardWithCategoryNameModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetDuplicatesAction extends AbstractGetDuplicatesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetDuplicatesAction.class);

	public GetDuplicatesAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				actionData.getCategoryId());
		if (category == null) {
			throwIllegalArgumentException("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel userAccessToCategoryModel = daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, actionData.getCategoryId(), actionData.getUserId());
		if (userAccessToCategoryModel == null) {
			throwSecurityException();
		}
		List<ICardWithCategoryNameModel> cardList = this.daoProvider.getCardDao().search(readonlyHandle, actionData.getCategoryId(),
				actionData.getNaturalInputOrder(), actionData.getGiven(), actionData.getWanted());
		this.actionData.setCardList(cardList);
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
