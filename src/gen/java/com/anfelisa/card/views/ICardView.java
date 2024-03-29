/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.views;

import de.acegen.Data;
import de.acegen.PersistenceHandle;

public interface ICardView {

	void insert(Data<com.anfelisa.card.models.CardCreationModel> data, PersistenceHandle handle);
	void delete(Data<com.anfelisa.card.models.CardDeleteModel> data, PersistenceHandle handle);
	void update(Data<com.anfelisa.card.models.CardUpdateModel> data, PersistenceHandle handle);
	void updatePriority(Data<com.anfelisa.card.models.CardUpdatePriorityModel> data, PersistenceHandle handle);
	void moveCards(Data<com.anfelisa.card.models.MoveCardsModel> data, PersistenceHandle handle);
	void bulkInsert(Data<com.anfelisa.card.models.CsvUploadModel> data, PersistenceHandle handle);
	void changeCardOrder(Data<com.anfelisa.card.models.ChangeCardOrderListModel> data, PersistenceHandle handle);
	
}




/******* S.D.G. *******/



