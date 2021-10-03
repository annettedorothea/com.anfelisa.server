/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class CategoryUpdateModel implements ICategoryUpdateModel {

	private String categoryId;

	private String categoryName;

	private String userId;


	public CategoryUpdateModel() {
	}

	public CategoryUpdateModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("userId") String userId
	) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.userId = userId;
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public ICategoryUpdateModel deepCopy() {
		ICategoryUpdateModel copy = new CategoryUpdateModel();
		copy.setCategoryId(this.getCategoryId());
		copy.setCategoryName(this.getCategoryName());
		copy.setUserId(this.getUserId());
		return copy;
	}

}



/******* S.D.G. *******/



