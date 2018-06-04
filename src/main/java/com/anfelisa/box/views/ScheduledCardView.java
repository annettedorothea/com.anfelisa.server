package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.box.data.RemoveCardFromBoxData;
import com.anfelisa.box.data.ScoreCardData;

public class ScheduledCardView {

	public ScheduledCardView(DaoProvider daoProvider) {
		super();
		//this.daoProvider = daoProvider;
	}
	public BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		//daoProvider.scheduledCardDao.updateByScheduledCardId(handle, dataContainer);
	};
	public  BiConsumer<RemoveCardFromBoxData, Handle> removeFromBox = (dataContainer, handle) -> {
		//daoProvider.customScheduledCardDao.removeScheduledCardFromBox(handle, dataContainer);
	};

}

/* S.D.G. */
