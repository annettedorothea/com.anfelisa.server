package com.anfelisa.card.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.card.data.CardCreationData;
import com.anfelisa.card.data.CardDeleteData;
import com.anfelisa.card.data.CardIdListData;
import com.anfelisa.card.data.CardUpdateData;
import com.anfelisa.card.models.ICardModel;

public class CardView implements ICardView {

	private IDaoProvider daoProvider;

	public CardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void insert(CardCreationData data, Handle handle) {
		daoProvider.getCardDao().insert(handle, data);
	}

	public void delete(CardDeleteData data, Handle handle) {
		daoProvider.getCardDao().deleteByCardId(handle, data.getCardId());
		daoProvider.getCardDao().shiftCards(handle, data.getCardIndex(), data.getCategoryId());
	}

	public void update(CardUpdateData data, Handle handle) {
		daoProvider.getCardDao().update(handle, data);
	}

	@Override
	public void moveCards(CardIdListData data, Handle handle) {
		for (ICardModel movedCard : data.getMovedCards()) {
			daoProvider.getCardDao().updateByCardId(handle, movedCard);
		}
	}

}

/* S.D.G. */
