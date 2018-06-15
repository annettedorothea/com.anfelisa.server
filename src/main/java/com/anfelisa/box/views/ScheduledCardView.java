package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.box.data.PostponeCardsData;
import com.anfelisa.box.data.ScoreCardData;

public class ScheduledCardView {

	private DaoProvider daoProvider;

	public ScheduledCardView(DaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}
	public BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		daoProvider.getCustomScheduledCardDao().score(handle, dataContainer);
	};
	public BiConsumer<ScoreCardData, Handle> scheduleNext = (dataContainer, handle) -> {
		daoProvider.getCustomScheduledCardDao().scheduleNext(handle, dataContainer);
	};
	public  BiConsumer<PostponeCardsData, Handle> postponeCards = (dataContainer, handle) -> {
		daoProvider.getCustomScheduledCardDao().postponeScheduledCards(handle, dataContainer);
	};

}

/* S.D.G. */
