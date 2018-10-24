package com.anfelisa.box.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.data.BoxUpdateData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.data.ScheduleCardData;
import com.anfelisa.box.data.ScheduleCardsData;
import com.anfelisa.box.models.IScheduledCardModel;

public class BoxView {

	private IDaoProvider daoProvider;

	public BoxView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<BoxCreationData, Handle> createBox = (dataContainer, handle) -> {
		daoProvider.getBoxDao().insert(handle, dataContainer);
	};

	public BiConsumer<BoxUpdateData, Handle> updateBox = (dataContainer, handle) -> {
		daoProvider.getCustomBoxDao().updateBox(handle, dataContainer);
	};

	public BiConsumer<DeleteBoxData, Handle> deleteBox = (dataContainer, handle) -> {
		daoProvider.getBoxDao().deleteByBoxId(handle, dataContainer.getBoxId());
	};

	public BiConsumer<ScheduleCardData, Handle> scheduleCard = (dataContainer, handle) -> {
		daoProvider.getScheduledCardDao().insert(handle, dataContainer);
	};
	
	public BiConsumer<ScheduleCardsData, Handle> scheduleCards = (dataContainer, handle) -> {
		List<IScheduledCardModel> newScheduledCards = dataContainer.getNewScheduledCards();
		for (IScheduledCardModel scheduledCardModel : newScheduledCards) {
			daoProvider.getScheduledCardDao().insert(handle, scheduledCardModel);
		}
		List<String> existingScheduledCardIds = dataContainer.getExistingScheduledCardIds();
		for (String scheduledCardId : existingScheduledCardIds) {
			daoProvider.getCustomScheduledCardDao().scheduleScheduledCard(handle, scheduledCardId, dataContainer.getScheduledDate());
		}
	};
	
}

/* S.D.G. */
