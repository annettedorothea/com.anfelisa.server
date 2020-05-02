package com.anfelisa.box.views;

import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.data.IInitMyBoxesDataData;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.IScoreReinforceCardData;
import com.anfelisa.box.data.ISortCardsOutData;

import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class ReinforceCardView implements IReinforceCardView {

	private IDaoProvider daoProvider;

	public ReinforceCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void add(IScoreCardData data, PersistenceHandle handle) {
		daoProvider.getReinforceCardDao().insert(handle, data);
	}

	public void remove(IScoreReinforceCardData data, PersistenceHandle handle) {
		daoProvider.getReinforceCardDao().deleteByReinforceCardId(handle, data.getReinforceCardId());
	}

	public void update(IScoreReinforceCardData data, PersistenceHandle handle) {
		daoProvider.getReinforceCardDao().updateChangeDate(handle, data.getReinforceCardId(), data.getChangeDate());
	}

	@Override
	public void clear(IInitMyBoxesDataData data, PersistenceHandle handle) {
		for (String scheduledCardId : data.getOutdatedReinforceCardsIds()) {
			daoProvider.getReinforceCardDao().deleteByScheduledCardId(handle, scheduledCardId);
		}
	}

	@Override
	public void deleteAll(IDeleteBoxData data, PersistenceHandle handle) {
		daoProvider.getReinforceCardDao().deleteByBoxId(handle, data.getBoxId());
	}

	@Override
	public void sortOut(ISortCardsOutData data, PersistenceHandle handle) {
		for (String reinforceCardId : data.getSortedOutReinforceCardIds()) {
			daoProvider.getReinforceCardDao().deleteByReinforceCardId(handle, reinforceCardId);
		}
	}

}

/* S.D.G. */
