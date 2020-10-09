package com.anfelisa.card.views;

import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.card.data.ICardDeleteData;
import com.anfelisa.card.data.ICardUpdateData;
import com.anfelisa.card.data.ICardUpdatePriorityData;
import com.anfelisa.card.data.IChangeCardOrderListData;
import com.anfelisa.card.data.ICsvUploadData;
import com.anfelisa.card.data.IMoveCardsData;
import com.anfelisa.card.models.ICardModel;

import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class CardView implements ICardView {

	private IDaoProvider daoProvider;

	public CardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void insert(ICardCreationData data, PersistenceHandle handle) {
		daoProvider.getCardDao().insert(handle, data);
	}

	public void delete(ICardDeleteData data, PersistenceHandle handle) {
		daoProvider.getCardDao().deleteByCardId(handle, data.getCardId());
		daoProvider.getCardDao().shiftCards(handle, data.getCardIndex(), data.getCategoryId());
	}

	public void update(ICardUpdateData data, PersistenceHandle handle) {
		daoProvider.getCardDao().update(handle, data);
	}

	@Override
	public void moveCards(IMoveCardsData data, PersistenceHandle handle) {
		for (ICardModel movedCard : data.getMovedCards()) {
			daoProvider.getCardDao().moveCard(handle, movedCard);
		}
		for (ICardModel card : data.getUpdatedIndices()) {
			daoProvider.getCardDao().updateIndex(handle, card);
		}
	}

	@Override
	public void bulkInsert(ICsvUploadData data, PersistenceHandle handle) {
		for (ICardModel card : data.getCards()) {
			daoProvider.getCardDao().insert(handle, card);
		}
	}

	@Override
	public void changeCardOrder(IChangeCardOrderListData data, PersistenceHandle handle) {
		for (ICardModel card : data.getUpdatedIndices()) {
			daoProvider.getCardDao().updateIndex(handle, card);
		}
	}

	@Override
	public void updatePriority(ICardUpdatePriorityData data, PersistenceHandle handle) {
		daoProvider.getCardDao().updateCardPriority(handle, data);
	}

}

/* S.D.G. */
