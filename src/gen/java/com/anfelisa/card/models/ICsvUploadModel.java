/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CsvUploadModel.class)
public interface ICsvUploadModel {

	String getUserId();
	void setUserId(String userId);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	java.util.List<com.anfelisa.card.models.ISimpleCardModel> getPreviewCsv();
	void setPreviewCsv(java.util.List<com.anfelisa.card.models.ISimpleCardModel> previewCsv);
	
	java.util.List<com.anfelisa.card.models.ICardModel> getCards();
	void setCards(java.util.List<com.anfelisa.card.models.ICardModel> cards);
	
	
	ICsvUploadModel deepCopy();
}




/******* S.D.G. *******/



