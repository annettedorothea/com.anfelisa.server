package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.CardOfBoxCreationData;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.models.CardOfBoxDao;

public class CardOfBoxView {

	private CardOfBoxDao cardOfBoxDao = new CardOfBoxDao();

	public BiConsumer<CardOfBoxCreationData, Handle> createCardOfBox = (dataContainer, handle) -> {
		Integer id = cardOfBoxDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId("" + id);
	};

	public BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		Integer id = cardOfBoxDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId("" + id);
	};

}

/* S.D.G. */
