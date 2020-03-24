package com.anfelisa.box.views;

import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.data.IInitMyBoxesDataData;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.models.IPostponeCardsModel;

import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class ScheduledCardView implements IScheduledCardView {

	private IDaoProvider daoProvider;

	public ScheduledCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void score(IScoreCardData data, PersistenceHandle handle) {
		daoProvider.getScheduledCardDao().score(handle, data);
	}

	public void scheduleNext(IScoreCardData data, PersistenceHandle handle) {
		daoProvider.getScheduledCardDao().scheduleNext(handle, data);
	}

	@Override
	public void postponeCards(IInitMyBoxesDataData data, PersistenceHandle handle) {
		for (IPostponeCardsModel postponeCards : data.getPostponeCards()) {
			daoProvider.getScheduledCardDao().postponeScheduledCards(handle, postponeCards);
		}
	}

	@Override
	public void deleteAll(IDeleteBoxData data, PersistenceHandle handle) {
		daoProvider.getScheduledCardDao().deleteByBoxId(handle, data.getBoxId());
	}

}

/* S.D.G. */
