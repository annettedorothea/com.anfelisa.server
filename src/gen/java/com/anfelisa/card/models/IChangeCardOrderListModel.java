/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ChangeCardOrderListModel.class)
public interface IChangeCardOrderListModel {

	java.util.List<String> getCardIdList();
	void setCardIdList(java.util.List<String> cardIdList);
	
	String getCardId();
	void setCardId(String cardId);
	
	String getUserId();
	void setUserId(String userId);
	
	java.util.List<com.anfelisa.card.models.ICardModel> getUpdatedIndices();
	void setUpdatedIndices(java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices);
	
	
	IChangeCardOrderListModel deepCopy();
}




/******* S.D.G. *******/



