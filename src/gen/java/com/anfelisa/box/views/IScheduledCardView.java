/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.views;

import de.acegen.Data;
import de.acegen.PersistenceHandle;

public interface IScheduledCardView {

	void score(Data<com.anfelisa.box.models.ScoreCardModel> data, PersistenceHandle handle);
	void scheduleNext(Data<com.anfelisa.box.models.ScoreCardModel> data, PersistenceHandle handle);
	void postponeCards(Data<com.anfelisa.box.models.InitMyBoxesDataModel> data, PersistenceHandle handle);
	void deleteAll(Data<com.anfelisa.box.models.DeleteBoxModel> data, PersistenceHandle handle);
	
}




/******* S.D.G. *******/



