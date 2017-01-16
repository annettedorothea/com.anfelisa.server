package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.CardCreationData;
import com.anfelisa.box.data.CardIdData;
import com.anfelisa.box.models.CardDao;

public class CardView {

	private CardDao cardDao = new CardDao();

	public BiConsumer<CardCreationData, Handle> createCard = (dataContainer, handle) -> {
		Integer cardId = cardDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId("" + cardId);
	};

	public BiConsumer<CardIdData, Handle> deleteCard = (dataContainer, handle) -> {
		cardDao.deleteByCardId(handle, dataContainer.getCardId(), dataContainer.getSchema());
	};

}

/* S.D.G. */
