package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.IPostponeCardsData;

@SuppressWarnings("all")
public interface IScheduledCardView {

	void score(IScoreCardData data, Handle handle);
	void scheduleNext(IScoreCardData data, Handle handle);
	void postponeCards(IPostponeCardsData data, Handle handle);

}

/*                    S.D.G.                    */
