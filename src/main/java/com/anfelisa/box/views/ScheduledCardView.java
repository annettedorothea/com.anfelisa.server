package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.RecalculateScheduledCardsData;
import com.anfelisa.box.data.RemoveCardFromBoxData;
import com.anfelisa.box.data.ScheduledCardData;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.models.CustomScheduledCardDao;
import com.anfelisa.box.models.ScheduledCardDao;

public class ScheduledCardView {

	private ScheduledCardDao scheduledCardDao = new ScheduledCardDao();

	private CustomScheduledCardDao customScheduledCardDao = new CustomScheduledCardDao();

	public BiConsumer<ScheduledCardData, Handle> createScheduledCard = (dataContainer, handle) -> {
		Integer id = scheduledCardDao.insert(handle, dataContainer);
		dataContainer.setCreatedId(id + "");
	};
	public BiConsumer<ScoreCardData, Handle> score = (dataContainer, handle) -> {
		scheduledCardDao.updateByScheduledCardId(handle, dataContainer);
	};
	public BiConsumer<RemoveCardFromBoxData, Handle> removeFromBox = (dataContainer, handle) -> {
		customScheduledCardDao.removeScheduledCardFromBox(handle, dataContainer);
	};
	public BiConsumer<RecalculateScheduledCardsData, Handle> recalculateScheduledCards = (dataContainer, handle) -> {
		customScheduledCardDao.recalculateScheduledCards(handle, dataContainer.getBoxId(), dataContainer.getDaysBehind());
	};

}

/* S.D.G. */
