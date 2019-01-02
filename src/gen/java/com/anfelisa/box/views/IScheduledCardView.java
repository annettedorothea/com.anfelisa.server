package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.data.PostponeCardsData;

@SuppressWarnings("all")
public interface IScheduledCardView {

	void score(ScoreCardData data, Handle handle);
	void scheduleNext(ScoreCardData data, Handle handle);
	void postponeCards(PostponeCardsData data, Handle handle);

}

/*                    S.D.G.                    */
