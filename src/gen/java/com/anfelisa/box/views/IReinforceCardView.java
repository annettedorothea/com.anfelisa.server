/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.views;

import de.acegen.Data;
import de.acegen.PersistenceHandle;

public interface IReinforceCardView {

	void add(Data<com.anfelisa.box.models.ScoreCardModel> data, PersistenceHandle handle);
	void remove(Data<com.anfelisa.box.models.ScoreReinforceCardModel> data, PersistenceHandle handle);
	void update(Data<com.anfelisa.box.models.ScoreReinforceCardModel> data, PersistenceHandle handle);
	void clear(Data<com.anfelisa.box.models.InitMyBoxesDataModel> data, PersistenceHandle handle);
	void deleteAll(Data<com.anfelisa.box.models.DeleteBoxModel> data, PersistenceHandle handle);
	void deleteAllOfBox(Data<com.anfelisa.box.models.ScheduledCardsModel> data, PersistenceHandle handle);
	void sortOut(Data<com.anfelisa.box.models.SortCardsOutModel> data, PersistenceHandle handle);
	
}




/******* S.D.G. *******/



