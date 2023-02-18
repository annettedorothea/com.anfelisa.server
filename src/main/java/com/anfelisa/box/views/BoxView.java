package com.anfelisa.box.views;

import java.util.List;

import com.anfelisa.box.models.BoxArchiveModel;
import com.anfelisa.box.models.BoxCreationModel;
import com.anfelisa.box.models.BoxUpdateModel;
import com.anfelisa.box.models.DeleteBoxModel;
import com.anfelisa.box.models.ScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardsModel;
import com.anfelisa.box.models.SortCardsOutModel;

import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class BoxView implements IBoxView {

	private IDaoProvider daoProvider;

	public BoxView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void updateBox(Data<BoxUpdateModel> data, PersistenceHandle handle) {
		daoProvider.getBoxDao().updateBox(handle, data.getModel());
	}

	public void deleteBox(Data<DeleteBoxModel> data, PersistenceHandle handle) {
		daoProvider.getBoxDao().deleteByBoxId(handle, data.getModel().getBoxId());
	}

	public void scheduleCards(Data<ScheduledCardsModel> data, PersistenceHandle handle) {
		List<ScheduledCardModel> newScheduledCards = data.getModel().getNewScheduledCards();
		for (ScheduledCardModel scheduledCardModel : newScheduledCards) {
			daoProvider.getScheduledCardDao().insert(handle, scheduledCardModel);
		}
		List<String> existingScheduledCardIds = data.getModel().getExistingScheduledCardIds();
		for (String scheduledCardId : existingScheduledCardIds) {
			daoProvider.getScheduledCardDao().scheduleScheduledCard(handle, scheduledCardId,
					data.getModel().getScheduledDate());
		}
	}

	@Override
	public void createBox(Data<BoxCreationModel> data, PersistenceHandle handle) {
		daoProvider.getBoxDao().insert(handle, data.getModel().mapToBoxModel());
	}

	@Override
	public void sortCardsOut(Data<SortCardsOutModel> data, PersistenceHandle handle) {
		for (String scheduledCardId : data.getModel().getSortedOutScheduledCardIds()) {
			daoProvider.getScheduledCardDao().sortOutCard(handle, scheduledCardId);
		}
	}

	@Override
	public void archiveBox(Data<BoxArchiveModel> data, PersistenceHandle handle) {
		daoProvider.getBoxDao().archive(handle, data.getModel().getBoxId(), data.getModel().getArchived());
	}

	@Override
	public void deleteReverseBox(Data<DeleteBoxModel> data, PersistenceHandle handle) {
		daoProvider.getBoxDao().deleteByBoxId(handle, data.getModel().getReverseBoxId());
	}

}

/* S.D.G. */
