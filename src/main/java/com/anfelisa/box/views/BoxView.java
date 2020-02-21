package com.anfelisa.box.views;

import java.util.List;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.IBoxCreationData;
import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.data.IScheduledCardsData;
import com.anfelisa.box.models.IScheduledCardModel;

public class BoxView implements IBoxView {

	private IDaoProvider daoProvider;
	
	public BoxView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void updateBox(IBoxUpdateData data, Handle handle) {
		daoProvider.getBoxDao().updateBox(handle, data);
	}
	public void deleteBox(IDeleteBoxData data, Handle handle) {
		daoProvider.getBoxDao().deleteByBoxId(handle, data.getBoxId());
	}
	public void scheduleCards(IScheduledCardsData data, Handle handle) {
		List<IScheduledCardModel> newScheduledCards = data.getNewScheduledCards();
		for (IScheduledCardModel scheduledCardModel : newScheduledCards) {
			daoProvider.getScheduledCardDao().insert(handle, scheduledCardModel);
		}
		List<String> existingScheduledCardIds = data.getExistingScheduledCardIds();
		for (String scheduledCardId : existingScheduledCardIds) {
			daoProvider.getScheduledCardDao().scheduleScheduledCard(handle, scheduledCardId, data.getScheduledDate());
		}
	}

	@Override
	public void createBox(IBoxCreationData data, Handle handle) {
		daoProvider.getBoxDao().insert(handle, data);
	}

}

/*                    S.D.G.                    */
