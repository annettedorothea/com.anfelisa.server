/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardWithInfoModel.class)
public interface ICardWithInfoModel extends com.anfelisa.card.models.ICardModel{

	java.time.LocalDateTime getNext();
	void setNext(java.time.LocalDateTime next);
	
	
	ICardWithInfoModel deepCopy();
}




/******* S.D.G. *******/



