package com.anfelisa.card.views;

import com.anfelisa.card.models.CardCreationModel;
import com.anfelisa.card.models.CardDeleteModel;
import com.anfelisa.card.models.CardModel;
import com.anfelisa.card.models.CardUpdateModel;
import com.anfelisa.card.models.CardUpdatePriorityModel;
import com.anfelisa.card.models.ChangeCardOrderListModel;
import com.anfelisa.card.models.CsvUploadModel;
import com.anfelisa.card.models.MoveCardsModel;

import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class CardView implements ICardView {

	private IDaoProvider daoProvider;

	public CardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void insert(Data<CardCreationModel> data, PersistenceHandle handle) {
		daoProvider.getCardDao().insert(handle, data.getModel().mapToCardModel());
	}

	public void delete(Data<CardDeleteModel> data, PersistenceHandle handle) {
		daoProvider.getCardDao().deleteByCardId(handle, data.getModel().getCardId());
		daoProvider.getCardDao().shiftCards(handle, data.getModel().getCardIndex(), data.getModel().getCategoryId());
	}

	public void update(Data<CardUpdateModel> data, PersistenceHandle handle) {
		daoProvider.getCardDao().update(handle, data.getModel());
	}

	@Override
	public void moveCards(Data<MoveCardsModel> data, PersistenceHandle handle) {
		for (CardModel movedCard : data.getModel().getMovedCards()) {
			daoProvider.getCardDao().moveCard(handle, movedCard);
		}
		for (CardModel card : data.getModel().getUpdatedIndices()) {
			daoProvider.getCardDao().updateIndex(handle, card);
		}
	}

	@Override
	public void bulkInsert(Data<CsvUploadModel> data, PersistenceHandle handle) {
		for (CardModel card : data.getModel().getCards()) {
			daoProvider.getCardDao().insert(handle, card);
		}
	}

	@Override
	public void changeCardOrder(Data<ChangeCardOrderListModel> data, PersistenceHandle handle) {
		for (CardModel card : data.getModel().getUpdatedIndices()) {
			daoProvider.getCardDao().updateIndex(handle, card);
		}
	}

	@Override
	public void updatePriority(Data<CardUpdatePriorityModel> data, PersistenceHandle handle) {
		daoProvider.getCardDao().updateCardPriority(handle, data.getModel());
	}

}

/* S.D.G. */
