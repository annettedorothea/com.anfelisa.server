package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.data.ScoredCardData;
import com.anfelisa.box.models.ScoredCardDao;

public class ScoredCardView {

	private static ScoredCardDao scoredCardDao = new ScoredCardDao();

	public static BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		Integer id = scoredCardDao.insert(handle, dataContainer);
		dataContainer.setCreatedId(id + "");
	};

	public static BiConsumer<ScoredCardData, Handle> createScoredCard = (dataContainer, handle) -> {
		Integer id = scoredCardDao.insert(handle, dataContainer);
		dataContainer.setCreatedId(id + "");
	};

}

/* S.D.G. */
