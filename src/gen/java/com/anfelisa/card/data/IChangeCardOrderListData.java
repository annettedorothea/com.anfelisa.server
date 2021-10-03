/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.IChangeCardOrderListModel;

@JsonDeserialize(as=ChangeCardOrderListData.class)
public interface IChangeCardOrderListData extends IChangeCardOrderListModel, IDataContainer {
	
	IChangeCardOrderListData withCardIdList(java.util.List<String> cardIdList);
	
	IChangeCardOrderListData withCardId(String cardId);
	
	IChangeCardOrderListData withUserId(String userId);
	
	IChangeCardOrderListData withUpdatedIndices(java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices);
	
	
	IChangeCardOrderListData deepCopy();
}



/******* S.D.G. *******/



