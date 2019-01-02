package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.data.ScoreReinforceCardData;

public class ReinforceCardView implements IReinforceCardView {

	private IDaoProvider daoProvider;

	public ReinforceCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void add(ScoreCardData data, Handle handle) {
		daoProvider.getReinforceCardDao().insert(handle, data);
	}

	public void remove(ScoreReinforceCardData data, Handle handle) {
		daoProvider.getReinforceCardDao().deleteByReinforceCardId(handle, data.getReinforceCardId());
	}

	public void update(ScoreReinforceCardData data, Handle handle) {
		daoProvider.getReinforceCardDao().updateChangeDate(handle, data.getReinforceCardId(), data.getChangeDate());
	}

}

/* S.D.G. */
