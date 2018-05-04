package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.box.data.CardCreationData;
import com.anfelisa.box.data.CardIdData;

public class CardView {

	//private DaoProvider daoProvider;
	
	public CardView(DaoProvider daoProvider) {
		super();
		//this.daoProvider = daoProvider;
	}

	public BiConsumer<CardCreationData, Handle> createCard = (dataContainer, handle) -> {
		/*String cardId = dataContainer.getCardId();
		ICardModel card = daoProvider.cardDao.selectByCardId(handle, cardId);
		if (card == null) {
			daoProvider.cardDao.insert(handle, dataContainer);
		} else {
			cardDao.updateByCardId(handle, dataContainer);
		}*/
	};

	public BiConsumer<CardIdData, Handle> deleteCard = (dataContainer, handle) -> {
		//daoProvider.cardDao.deleteByCardId(handle, dataContainer.getCardId());
	};

}

/* S.D.G. */
