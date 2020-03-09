package com.anfelisa.box.views;

import java.util.List;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
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

	public void updateBox(IBoxUpdateData data, PersistenceHandle handle) {
		daoProvider.getBoxDao().updateBox(handle, data);
	}
	public void deleteBox(IDeleteBoxData data, PersistenceHandle handle) {
		daoProvider.getBoxDao().deleteByBoxId(handle, data.getBoxId());
	}
	public void scheduleCards(IScheduledCardsData data, PersistenceHandle handle) {
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
	public void createBox(IBoxCreationData data, PersistenceHandle handle) {
		daoProvider.getBoxDao().insert(handle, data);
	}

}

/*                    S.D.G.                    */
