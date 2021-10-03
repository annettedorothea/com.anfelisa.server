/********************************************************************************
 * generated by de.acegen 1.5.6
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
public class UserAccessToCategoryModel implements IUserAccessToCategoryModel {

	private String categoryId;

	private String userId;

	private Boolean editable = false;


	public UserAccessToCategoryModel() {
	}

	public UserAccessToCategoryModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("editable") Boolean editable
	) {
		this.categoryId = categoryId;
		this.userId = userId;
		this.editable = editable;
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	

	public IUserAccessToCategoryModel deepCopy() {
		IUserAccessToCategoryModel copy = new UserAccessToCategoryModel();
		copy.setCategoryId(this.getCategoryId());
		copy.setUserId(this.getUserId());
		copy.setEditable(this.getEditable());
		return copy;
	}

}



/******* S.D.G. *******/



