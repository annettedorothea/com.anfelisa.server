/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICsvUploadModel;

@JsonDeserialize(as=CsvUploadData.class)
public interface ICsvUploadData extends ICsvUploadModel, IDataContainer {
	
	ICsvUploadData withUserId(String userId);
	
	ICsvUploadData withCategoryId(String categoryId);
	
	ICsvUploadData withPreviewCsv(java.util.List<com.anfelisa.card.models.ISimpleCardModel> previewCsv);
	
	ICsvUploadData withCards(java.util.List<com.anfelisa.card.models.ICardModel> cards);
	
	
	ICsvUploadData deepCopy();
}



/******* S.D.G. *******/



