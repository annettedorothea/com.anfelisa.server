/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.box.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.IInitMyBoxesDataData;
import com.anfelisa.box.data.IDeleteBoxData;

@SuppressWarnings("all")
public interface IScheduledCardView {

	void score(IScoreCardData data, PersistenceHandle handle);
	void scheduleNext(IScoreCardData data, PersistenceHandle handle);
	void postponeCards(IInitMyBoxesDataData data, PersistenceHandle handle);
	void deleteAll(IDeleteBoxData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



