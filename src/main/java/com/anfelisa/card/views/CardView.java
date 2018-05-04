package com.anfelisa.card.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.card.data.CardCreationData;
import com.anfelisa.card.data.CardDeleteData;
import com.anfelisa.card.data.CardUpdateData;

@SuppressWarnings("all")
public class CardView {

	private DaoProvider daoProvider;
	
	public CardView(DaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}
	public BiConsumer<CardCreationData, Handle> insert = (dataContainer, handle) -> {
		daoProvider.cardDao.insert(handle, dataContainer);
	};
	public BiConsumer<CardDeleteData, Handle> delete = (dataContainer, handle) -> {
		daoProvider.cardDao.deleteByCardId(handle, dataContainer.getCardId());
	};
	public BiConsumer<CardUpdateData, Handle> update = (dataContainer, handle) -> {
		daoProvider.customCardDao.update(handle, dataContainer);
	};

}

/*                    S.D.G.                    */
