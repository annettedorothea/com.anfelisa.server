package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.ScoreCardData;

@SuppressWarnings("all")
public class ReinforceCardView {

	private IDaoProvider daoProvider;
	
	public ReinforceCardView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<ScoreCardData, Handle> add = (dataContainer, handle) -> {
	};

}

/*                    S.D.G.                    */
