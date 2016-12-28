package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.CardOfBoxCreationData;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.models.CardOfBoxDao;

public class CardOfBoxView {

	public BiConsumer<CardOfBoxCreationData, Handle> createCardOfBox = (dataContainer, handle) -> {
		CardOfBoxDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		CardOfBoxDao.insert(handle, dataContainer, dataContainer.getSchema());
	};
	
}

/*                    S.D.G.                    */
