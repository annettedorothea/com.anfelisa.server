package com.anfelisa.box.views;

import java.util.List;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.BoxData;
import com.anfelisa.box.data.BoxUpdateData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.data.ScheduleNextCardData;
import com.anfelisa.box.data.ScheduledCardsData;
import com.anfelisa.box.models.IScheduledCardModel;

public class BoxView implements IBoxView {

	private IDaoProvider daoProvider;
	
	public BoxView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void createBox(BoxData data, Handle handle) {
		daoProvider.getBoxDao().insert(handle, data);
	}
	public void updateBox(BoxUpdateData data, Handle handle) {
		daoProvider.getBoxDao().updateBox(handle, data);
	}
	public void deleteBox(DeleteBoxData data, Handle handle) {
		daoProvider.getBoxDao().deleteByBoxId(handle, data.getBoxId());
	}
	public void scheduleCard(ScheduleNextCardData data, Handle handle) {
		daoProvider.getScheduledCardDao().insert(handle, data);
	}
	public void scheduleCards(ScheduledCardsData data, Handle handle) {
		List<IScheduledCardModel> newScheduledCards = data.getNewScheduledCards();
		for (IScheduledCardModel scheduledCardModel : newScheduledCards) {
			daoProvider.getScheduledCardDao().insert(handle, scheduledCardModel);
		}
		List<String> existingScheduledCardIds = data.getExistingScheduledCardIds();
		for (String scheduledCardId : existingScheduledCardIds) {
			daoProvider.getScheduledCardDao().scheduleScheduledCard(handle, scheduledCardId, data.getScheduledDate());
		}
	}


}

/*                    S.D.G.                    */
