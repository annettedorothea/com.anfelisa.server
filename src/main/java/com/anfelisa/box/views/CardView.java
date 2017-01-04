package com.anfelisa.box.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.CardCreationData;
import com.anfelisa.box.data.ContentHashesOfCreatedCardsData;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.CustomCardDao;

public class CardView {

	public BiConsumer<CardCreationData, Handle> createCard = (dataContainer, handle) -> {
		Integer cardId = CardDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCardId(cardId);
	};

	public BiConsumer<ContentHashesOfCreatedCardsData, Handle> deleteObsoleteCards = (dataContainer, handle) -> {
		List<String> obsoleteHashes = dataContainer.getContentHashesOfObsoleteCards();
		for (String contentHash : obsoleteHashes) {
			CustomCardDao.deleteByHash(handle, dataContainer.getSchema(), contentHash);
		}
	};
	
}

/*                    S.D.G.                    */
