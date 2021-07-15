/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxViewModel.class)
public interface IBoxViewModel {

	Integer getOpenTodaysCards();
	void setOpenTodaysCards(Integer openTodaysCards);
	
	String getCategoryName();
	void setCategoryName(String categoryName);
	
	String getCategoryAuthor();
	void setCategoryAuthor(String categoryAuthor);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	Boolean getReverse();
	void setReverse(Boolean reverse);
	
	Boolean getEditable();
	void setEditable(Boolean editable);
	
	
	IBoxViewModel deepCopy();
}




/******* S.D.G. *******/



