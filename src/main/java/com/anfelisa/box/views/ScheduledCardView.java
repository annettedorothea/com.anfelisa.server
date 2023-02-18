package com.anfelisa.box.views;

import com.anfelisa.box.models.DeleteBoxModel;
import com.anfelisa.box.models.InitMyBoxesDataModel;
import com.anfelisa.box.models.PostponeCardsModel;
import com.anfelisa.box.models.ScoreCardModel;

import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class ScheduledCardView implements IScheduledCardView {

	private IDaoProvider daoProvider;

	public ScheduledCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void score(Data<ScoreCardModel> data, PersistenceHandle handle) {
		daoProvider.getScheduledCardDao().score(handle, data.getModel());
	}

	public void scheduleNext(Data<ScoreCardModel> data, PersistenceHandle handle) {
		daoProvider.getScheduledCardDao().scheduleNext(handle, data.getModel());
	}

	@Override
	public void postponeCards(Data<InitMyBoxesDataModel> data, PersistenceHandle handle) {
		for (PostponeCardsModel postponeCards : data.getModel().getPostponeCards()) {
			daoProvider.getScheduledCardDao().postponeScheduledCards(handle, postponeCards);
		}
	}

	@Override
	public void deleteAll(Data<DeleteBoxModel> data, PersistenceHandle handle) {
		daoProvider.getScheduledCardDao().deleteByBoxId(handle, data.getModel().getBoxId());
	}

}

/* S.D.G. */
