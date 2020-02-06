package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.IInitMyBoxesDataData;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.IScoreReinforceCardData;

public class ReinforceCardView implements IReinforceCardView {

	private IDaoProvider daoProvider;

	public ReinforceCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void add(IScoreCardData data, Handle handle) {
		daoProvider.getReinforceCardDao().insert(handle, data);
	}

	public void remove(IScoreReinforceCardData data, Handle handle) {
		daoProvider.getReinforceCardDao().deleteByReinforceCardId(handle, data.getReinforceCardId());
	}

	public void update(IScoreReinforceCardData data, Handle handle) {
		daoProvider.getReinforceCardDao().updateChangeDate(handle, data.getReinforceCardId(), data.getChangeDate());
	}

	@Override
	public void clear(IInitMyBoxesDataData data, Handle handle) {
		for (String cardId : data.getOutdatedReinforceCardsIds()) {
			daoProvider.getReinforceCardDao().deleteByScheduledCardId(handle, cardId);
		}
		
	}

}

/* S.D.G. */
