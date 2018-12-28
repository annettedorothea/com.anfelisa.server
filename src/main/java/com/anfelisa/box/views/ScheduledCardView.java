package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.PostponeCardsData;
import com.anfelisa.box.data.ScoreCardData;

public class ScheduledCardView {

	private IDaoProvider daoProvider;

	public ScheduledCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}
	public BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		daoProvider.getScheduledCardDao().score(handle, dataContainer);
	};
	public BiConsumer<ScoreCardData, Handle> scheduleNext = (dataContainer, handle) -> {
		daoProvider.getScheduledCardDao().scheduleNext(handle, dataContainer);
	};
	public  BiConsumer<PostponeCardsData, Handle> postponeCards = (dataContainer, handle) -> {
		daoProvider.getScheduledCardDao().postponeScheduledCards(handle, dataContainer);
	};

}

/* S.D.G. */
