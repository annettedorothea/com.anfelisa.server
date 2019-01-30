package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.IScoreReinforceCardData;
import com.anfelisa.box.data.IScoreReinforceCardData;

@SuppressWarnings("all")
public interface IReinforceCardView {

	void add(IScoreCardData data, Handle handle);
	void remove(IScoreReinforceCardData data, Handle handle);
	void update(IScoreReinforceCardData data, Handle handle);

}

/*                    S.D.G.                    */
