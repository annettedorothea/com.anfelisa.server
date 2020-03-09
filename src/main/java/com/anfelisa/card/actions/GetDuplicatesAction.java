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
import com.anfelisa.card.models.ICardWithCategoryNameModel;

public class GetDuplicatesAction extends AbstractGetDuplicatesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetDuplicatesAction.class);

	public GetDuplicatesAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider, e2e);
	}


	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		List<ICardWithCategoryNameModel> cardList = this.daoProvider.getCardDao().search(readonlyHandle, actionData.getCategoryId(),
				actionData.getNaturalInputOrder(), actionData.getGiven(), actionData.getWanted());
		this.actionData.setCardList(cardList);
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
