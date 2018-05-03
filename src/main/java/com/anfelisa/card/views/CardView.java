package com.anfelisa.card.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.card.data.CardCreationData;
import com.anfelisa.card.data.CardDeleteData;
import com.anfelisa.card.data.CardUpdateData;
import com.anfelisa.card.model.CustomCardDao;
import com.anfelisa.card.models.CardDao;

@SuppressWarnings("all")
public class CardView {

	private static CardDao cardDao = new CardDao();
	
	private static CustomCardDao customCardDao = new CustomCardDao();
	
	public static BiConsumer<CardCreationData, Handle> insert = (dataContainer, handle) -> {
		cardDao.insert(handle, dataContainer);
	};
	public static BiConsumer<CardDeleteData, Handle> delete = (dataContainer, handle) -> {
		cardDao.deleteByCardId(handle, dataContainer.getCardId());
	};
	public static BiConsumer<CardUpdateData, Handle> update = (dataContainer, handle) -> {
		customCardDao.update(handle, dataContainer);
	};

}

/*                    S.D.G.                    */
