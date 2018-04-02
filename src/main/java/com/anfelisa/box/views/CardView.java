package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.CardCreationData;
import com.anfelisa.box.data.CardIdData;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.ICardModel;

public class CardView {

	private static CardDao cardDao = new CardDao();

	public static BiConsumer<CardCreationData, Handle> createCard = (dataContainer, handle) -> {
		String cardId = dataContainer.getCardId();
		ICardModel card = cardDao.selectByCardId(handle, cardId);
		if (card == null) {
			cardDao.insert(handle, dataContainer);
		} else {
			cardDao.updateByCardId(handle, dataContainer);
		}
	};

	public static BiConsumer<CardIdData, Handle> deleteCard = (dataContainer, handle) -> {
		cardDao.deleteByCardId(handle, dataContainer.getCardId());
	};

}

/* S.D.G. */
