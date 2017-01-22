package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.data.ScoredCardData;
import com.anfelisa.box.models.ScoredCardDao;

public class ScoredCardView {
	
	private ScoredCardDao scoredCardDao = new ScoredCardDao();

	public BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		Integer id = scoredCardDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId(id + "");
	};

	public BiConsumer<ScoredCardData, Handle> createScoredCard = (dataContainer, handle) -> {
		Integer id = scoredCardDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId(id + "");
	};
	
}

/*                    S.D.G.                    */
