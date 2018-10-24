package com.anfelisa.card.views;

import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.card.data.CardCreationData;
import com.anfelisa.card.data.CardDeleteData;
import com.anfelisa.card.data.CardUpdateData;

@SuppressWarnings("all")
public class CardView {

	private IDaoProvider daoProvider;
	
	public CardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}
	public BiConsumer<CardCreationData, Handle> insert = (dataContainer, handle) -> {
		daoProvider.getCardDao().insert(handle, dataContainer);
	};
	public BiConsumer<CardDeleteData, Handle> delete = (dataContainer, handle) -> {
		daoProvider.getCardDao().deleteByCardId(handle, dataContainer.getCardId());
		daoProvider.getCustomCardDao().shiftCards(handle, dataContainer.getCardIndex(), dataContainer.getCategoryId());
	};
	public BiConsumer<CardUpdateData, Handle> update = (dataContainer, handle) -> {
		daoProvider.getCustomCardDao().update(handle, dataContainer);
	};

}

/*                    S.D.G.                    */
