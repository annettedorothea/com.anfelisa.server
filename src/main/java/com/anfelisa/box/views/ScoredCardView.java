package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.box.data.ScoreCardData;

public class ScoredCardView {

	//private DaoProvider daoProvider;

	public ScoredCardView(DaoProvider daoProvider) {
		super();
		//this.daoProvider = daoProvider;
	}

	public BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		//daoProvider.scoredCardDao.insert(handle, dataContainer);
	};

}

/* S.D.G. */
