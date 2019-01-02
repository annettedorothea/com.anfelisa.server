package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.data.BoxData;
import com.anfelisa.box.data.BoxUpdateData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.data.ScheduleNextCardData;
import com.anfelisa.box.data.ScheduledCardsData;

@SuppressWarnings("all")
public interface IBoxView {

	void createBox(BoxData data, Handle handle);
	void updateBox(BoxUpdateData data, Handle handle);
	void deleteBox(DeleteBoxData data, Handle handle);
	void scheduleCard(ScheduleNextCardData data, Handle handle);
	void scheduleCards(ScheduledCardsData data, Handle handle);

}

/*                    S.D.G.                    */
