package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.data.ScoredCardData;
import com.anfelisa.box.models.ScoredCardDao;

public class ScoredCardView {

	private static ScoredCardDao scoredCardDao = new ScoredCardDao();

	public static BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		scoredCardDao.insert(handle, dataContainer);
	};

	public static BiConsumer<ScoredCardData, Handle> createScoredCard = (dataContainer, handle) -> {
		scoredCardDao.insert(handle, dataContainer);
	};

}

/* S.D.G. */
