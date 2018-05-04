package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.box.data.RecalculateScheduledCardsData;
import com.anfelisa.box.data.RemoveCardFromBoxData;
import com.anfelisa.box.data.ScheduledCardData;
import com.anfelisa.box.data.ScoreCardData;

public class ScheduledCardView {

	private DaoProvider daoProvider;
	
	public ScheduledCardView(DaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}
	public BiConsumer<ScheduledCardData, Handle> createScheduledCard = (dataContainer, handle) -> {
		daoProvider.scheduledCardDao.insert(handle, dataContainer);
	};
	public BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		daoProvider.scheduledCardDao.updateByScheduledCardId(handle, dataContainer);
	};
	public  BiConsumer<RemoveCardFromBoxData, Handle> removeFromBox = (dataContainer, handle) -> {
		daoProvider.customScheduledCardDao.removeScheduledCardFromBox(handle, dataContainer);
	};
	public  BiConsumer<RecalculateScheduledCardsData, Handle> recalculateScheduledCards = (dataContainer, handle) -> {
		daoProvider.customScheduledCardDao.recalculateScheduledCards(handle, dataContainer.getBoxId(), dataContainer.getDaysBehind());
	};

}

/* S.D.G. */
