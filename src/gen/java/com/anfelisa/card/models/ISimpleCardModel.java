/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=SimpleCardModel.class)
public interface ISimpleCardModel {

	String getGiven();
	void setGiven(String given);
	
	String getWanted();
	void setWanted(String wanted);
	
	String getId();
	void setId(String id);
	
	
	ISimpleCardModel deepCopy();
}




/******* S.D.G. *******/



