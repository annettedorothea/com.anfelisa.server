/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.category.data;

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
public class UpdateCategoryPayload implements IUpdateCategoryPayload {
	
	private String categoryId;
	
	private String categoryName;
	
	public UpdateCategoryPayload() {
	}
	
	public UpdateCategoryPayload(com.anfelisa.category.models.ICategoryUpdateModel data) {
		categoryId = data.getCategoryId();
		categoryName = data.getCategoryName();
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	
}



/******* S.D.G. *******/



