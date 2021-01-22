package com.anfelisa.card.actions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.card.models.ICardWithInfoModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetCardsAction extends AbstractGetCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsAction.class);

	public GetCardsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
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
		IBoxModel box = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle,
				category.getRootCategoryId(), actionData.getUserId(), actionData.getReverse());
		if (box == null) {
			throwIllegalArgumentException("boxNotFound");
		}

		List<ICardWithInfoModel> allCards = daoProvider.getCardDao().selectAllOfCategory(readonlyHandle,
				actionData.getCategoryId());
		List<ICardWithInfoModel> cardList = new ArrayList<>();
		for (ICardWithInfoModel card : allCards) {
			LocalDateTime scheduledDate = daoProvider.getScheduledCardDao()
					.selectUnscoredScheduledDateByCardIdAndBoxId(readonlyHandle, card.getCardId(), box.getBoxId());
			if (scheduledDate == null) {
				cardList.add(card);
			} else if (!this.actionData.getFilterNonScheduled()) {
				card.setNext(scheduledDate);
				cardList.add(card);
			}
		}
		this.actionData.setCardList(cardList);
	}

	@Override
	public void initActionData() {
	}

}

/* S.D.G. */
