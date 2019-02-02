package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CategoryUpdateModel implements ICategoryUpdateModel {

	@NotNull
	private String categoryId;
	
	@NotNull
	private String categoryName;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	private String userId;
	

	public CategoryUpdateModel() {
	}

	public CategoryUpdateModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("userId") String userId
	) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
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
	public Boolean getDictionaryLookup() {
		return this.dictionaryLookup;
	}
	public void setDictionaryLookup(Boolean dictionaryLookup) {
		this.dictionaryLookup = dictionaryLookup;
	}
	
	@JsonProperty
	public String getGivenLanguage() {
		return this.givenLanguage;
	}
	public void setGivenLanguage(String givenLanguage) {
		this.givenLanguage = givenLanguage;
	}
	
	@JsonProperty
	public String getWantedLanguage() {
		return this.wantedLanguage;
	}
	public void setWantedLanguage(String wantedLanguage) {
		this.wantedLanguage = wantedLanguage;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public List<String> equalsPrimitiveTypes(ICategoryUpdateModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getCategoryName() == null && other.getCategoryName() == null) && !this.getCategoryName().equals(other.getCategoryName())) {
			differingAttributes.add("categoryName: " + this.getCategoryName() + " " + other.getCategoryName());
		}
		if (!(this.getDictionaryLookup() == null && other.getDictionaryLookup() == null) && !this.getDictionaryLookup().equals(other.getDictionaryLookup())) {
			differingAttributes.add("dictionaryLookup: " + this.getDictionaryLookup() + " " + other.getDictionaryLookup());
		}
		if (!(this.getGivenLanguage() == null && other.getGivenLanguage() == null) && !this.getGivenLanguage().equals(other.getGivenLanguage())) {
			differingAttributes.add("givenLanguage: " + this.getGivenLanguage() + " " + other.getGivenLanguage());
		}
		if (!(this.getWantedLanguage() == null && other.getWantedLanguage() == null) && !this.getWantedLanguage().equals(other.getWantedLanguage())) {
			differingAttributes.add("wantedLanguage: " + this.getWantedLanguage() + " " + other.getWantedLanguage());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
}

/*       S.D.G.       */
