package com.anfelisa.box.views;

import com.anfelisa.box.models.DeleteBoxModel;
import com.anfelisa.box.models.InitMyBoxesDataModel;
import com.anfelisa.box.models.ScheduledCardsModel;
import com.anfelisa.box.models.ScoreCardModel;
import com.anfelisa.box.models.ScoreReinforceCardModel;
import com.anfelisa.box.models.SortCardsOutModel;

import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class ReinforceCardView implements IReinforceCardView {

	private IDaoProvider daoProvider;

	public ReinforceCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void add(Data<ScoreCardModel> data, PersistenceHandle handle) {
		daoProvider.getReinforceCardDao().insert(handle, data.getModel());
	}

	public void remove(Data<ScoreReinforceCardModel> data, PersistenceHandle handle) {
		daoProvider.getReinforceCardDao().deleteByReinforceCardId(handle, data.getModel().getReinforceCardId());
	}

	public void update(Data<ScoreReinforceCardModel> data, PersistenceHandle handle) {
		daoProvider.getReinforceCardDao().updateChangeDate(handle, data.getModel().getReinforceCardId(), data.getModel().getChangeDate());
	}

	@Override
	public void clear(Data<InitMyBoxesDataModel> data, PersistenceHandle handle) {
		for (String scheduledCardId : data.getModel().getOutdatedReinforceCardsIds()) {
			daoProvider.getReinforceCardDao().deleteByScheduledCardId(handle, scheduledCardId);
		}
	}

	@Override
	public void deleteAll(Data<DeleteBoxModel> data, PersistenceHandle handle) {
		daoProvider.getReinforceCardDao().deleteByBoxId(handle, data.getModel().getBoxId());
	}

	@Override
	public void sortOut(Data<SortCardsOutModel> data, PersistenceHandle handle) {
		for (String reinforceCardId : data.getModel().getSortedOutReinforceCardIds()) {
			daoProvider.getReinforceCardDao().deleteByReinforceCardId(handle, reinforceCardId);
		}
	}

	@Override
	public void deleteAllOfBox(Data<ScheduledCardsModel> data, PersistenceHandle handle) {
		daoProvider.getReinforceCardDao().deleteByBoxId(handle, data.getModel().getBoxId());
	}

}

/* S.D.G. */
