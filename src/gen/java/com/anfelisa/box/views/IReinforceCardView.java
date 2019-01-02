package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.data.ScoreReinforceCardData;
import com.anfelisa.box.data.ScoreReinforceCardData;

@SuppressWarnings("all")
public interface IReinforceCardView {

	void add(ScoreCardData data, Handle handle);
	void remove(ScoreReinforceCardData data, Handle handle);
	void update(ScoreReinforceCardData data, Handle handle);

}

/*                    S.D.G.                    */
