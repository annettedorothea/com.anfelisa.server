/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class ImportCsvPayload implements IImportCsvPayload {
	
	private java.util.List<com.anfelisa.card.models.ISimpleCardModel> previewCsv;
	
	private String categoryId;
	
	public ImportCsvPayload() {
	}
	
	public ImportCsvPayload(com.anfelisa.card.models.ICsvUploadModel data) {
		previewCsv = data.getPreviewCsv();
		categoryId = data.getCategoryId();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ISimpleCardModel> getPreviewCsv() {
		return this.previewCsv;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
}



/******* S.D.G. *******/



