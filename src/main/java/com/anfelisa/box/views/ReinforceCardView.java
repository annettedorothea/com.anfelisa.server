package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.data.ScoreReinforceCardData;

@SuppressWarnings("all")
public class ReinforceCardView {

	private IDaoProvider daoProvider;
	
	public ReinforceCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<ScoreCardData, Handle> add = (dataContainer, handle) -> {
		daoProvider.getCustomReinforceCardDao().insert(handle, dataContainer);
	};

	public BiConsumer<ScoreReinforceCardData, Handle> remove = (dataContainer, handle) -> {
		daoProvider.getReinforceCardDao().deleteByReinforceCardId(handle, dataContainer.getReinforceCardId());
	};
	
	public BiConsumer<ScoreReinforceCardData, Handle> update = (dataContainer, handle) -> {
		daoProvider.getCustomReinforceCardDao().updateChangeDate(handle, dataContainer.getReinforceCardId(), dataContainer.getChangeDate());
	};
	
}

/*                    S.D.G.                    */
