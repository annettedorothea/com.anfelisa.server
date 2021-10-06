/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.card.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.card.data.ICardDeleteData;
import com.anfelisa.card.data.ICardUpdateData;
import com.anfelisa.card.data.ICardUpdatePriorityData;
import com.anfelisa.card.data.IMoveCardsData;
import com.anfelisa.card.data.ICsvUploadData;
import com.anfelisa.card.data.IChangeCardOrderListData;

@SuppressWarnings("all")
public interface ICardView {

	void insert(ICardCreationData data, PersistenceHandle handle);
	void delete(ICardDeleteData data, PersistenceHandle handle);
	void update(ICardUpdateData data, PersistenceHandle handle);
	void updatePriority(ICardUpdatePriorityData data, PersistenceHandle handle);
	void moveCards(IMoveCardsData data, PersistenceHandle handle);
	void bulkInsert(ICsvUploadData data, PersistenceHandle handle);
	void changeCardOrder(IChangeCardOrderListData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



