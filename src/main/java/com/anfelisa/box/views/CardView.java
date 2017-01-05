package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.CardCreationData;
import com.anfelisa.box.data.CardIdData;
import com.anfelisa.box.models.CardDao;

public class CardView {

	public BiConsumer<CardCreationData, Handle> createCard = (dataContainer, handle) -> {
		Integer cardId = CardDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId("" + cardId);
	};

	public BiConsumer<CardIdData, Handle> deleteCard = (dataContainer, handle) -> {
		CardDao.deleteByCardId(handle, dataContainer.getCardId(), dataContainer.getSchema());
	};
	
}

/*                    S.D.G.                    */
