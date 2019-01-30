package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.data.IBoxData;
import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.data.IScheduleNextCardData;
import com.anfelisa.box.data.IScheduledCardsData;

@SuppressWarnings("all")
public interface IBoxView {

	void createBox(IBoxData data, Handle handle);
	void updateBox(IBoxUpdateData data, Handle handle);
	void deleteBox(IDeleteBoxData data, Handle handle);
	void scheduleCard(IScheduleNextCardData data, Handle handle);
	void scheduleCards(IScheduledCardsData data, Handle handle);

}

/*                    S.D.G.                    */
