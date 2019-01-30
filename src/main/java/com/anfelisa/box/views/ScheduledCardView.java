package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.IPostponeCardsData;
import com.anfelisa.box.data.IScoreCardData;

public class ScheduledCardView implements IScheduledCardView {

	private IDaoProvider daoProvider;

	public ScheduledCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void score(IScoreCardData data, Handle handle) {
		daoProvider.getScheduledCardDao().score(handle, data);
	}

	public void scheduleNext(IScoreCardData data, Handle handle) {
		daoProvider.getScheduledCardDao().scheduleNext(handle, data);
	}

	public void postponeCards(IPostponeCardsData data, Handle handle) {
		daoProvider.getScheduledCardDao().postponeScheduledCards(handle, data);
	}

}

/* S.D.G. */
