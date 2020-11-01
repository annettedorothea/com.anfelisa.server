/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.box.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.box.data.IBoxCreationData;
import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.data.IScheduledCardsData;
import com.anfelisa.box.data.ISortCardsOutData;

@SuppressWarnings("all")
public interface IBoxView {

	void createBox(IBoxCreationData data, PersistenceHandle handle);
	void updateBox(IBoxUpdateData data, PersistenceHandle handle);
	void deleteBox(IDeleteBoxData data, PersistenceHandle handle);
	void scheduleCards(IScheduledCardsData data, PersistenceHandle handle);
	void sortCardsOut(ISortCardsOutData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



