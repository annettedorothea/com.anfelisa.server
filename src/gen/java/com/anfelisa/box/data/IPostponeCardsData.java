package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IPostponeCardsModel;

@JsonDeserialize(as=PostponeCardsData.class)
public interface IPostponeCardsData extends IPostponeCardsModel, IDataContainer {
	
	IPostponeCardsData withDays(Integer days);
	
	IPostponeCardsData withBoxId(String boxId);
	
	IPostponeCardsData withUserId(String userId);
	
	IPostponeCardsData withToday(org.joda.time.DateTime today);
	
	
}

/*       S.D.G.       */
