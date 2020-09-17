/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.ISortCardsOutModel;

@JsonDeserialize(as=SortCardsOutData.class)
public interface ISortCardsOutData extends ISortCardsOutModel, IDataContainer {
	
	ISortCardsOutData withSortedOutScheduledCardIds(java.util.List<String> sortedOutScheduledCardIds);
	
	ISortCardsOutData withSortedOutReinforceCardIds(java.util.List<String> sortedOutReinforceCardIds);
	
	ISortCardsOutData withCardIds(java.util.List<String> cardIds);
	
	ISortCardsOutData withUserId(String userId);
	
	ISortCardsOutData withBoxId(String boxId);
	
	
}



/******* S.D.G. *******/



