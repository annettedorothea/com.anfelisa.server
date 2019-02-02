package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CategoryModel implements ICategoryModel {

	@NotNull
	private String categoryId;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private String categoryAuthor;
	
	@NotNull
	private Integer categoryIndex;
	
	private String parentCategoryId;
	
	private String rootCategoryId;
	
	private Boolean dictionaryLookup = false;
	
	private String givenLanguage;
	
	private String wantedLanguage;
	
	private Boolean publicRootCategory = false;
	

	public CategoryModel() {
	}

	public CategoryModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryAuthor") String categoryAuthor,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("parentCategoryId") String parentCategoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup,
		@JsonProperty("givenLanguage") String givenLanguage,
		@JsonProperty("wantedLanguage") String wantedLanguage,
		@JsonProperty("publicRootCategory") Boolean publicRootCategory
	) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryAuthor = categoryAuthor;
		this.categoryIndex = categoryIndex;
		this.parentCategoryId = parentCategoryId;
		this.rootCategoryId = rootCategoryId;
		this.dictionaryLookup = dictionaryLookup;
		this.givenLanguage = givenLanguage;
		this.wantedLanguage = wantedLanguage;
		this.publicRootCategory = publicRootCategory;
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
	public String getCategoryAuthor() {
		return this.categoryAuthor;
	}
	public void setCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
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
	public Boolean getPublicRootCategory() {
		return this.publicRootCategory;
	}
	public void setPublicRootCategory(Boolean publicRootCategory) {
		this.publicRootCategory = publicRootCategory;
	}
	
	
	public List<String> equalsPrimitiveTypes(ICategoryModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getCategoryName() == null && other.getCategoryName() == null) && !this.getCategoryName().equals(other.getCategoryName())) {
			differingAttributes.add("categoryName: " + this.getCategoryName() + " " + other.getCategoryName());
		}
		if (!(this.getCategoryAuthor() == null && other.getCategoryAuthor() == null) && !this.getCategoryAuthor().equals(other.getCategoryAuthor())) {
			differingAttributes.add("categoryAuthor: " + this.getCategoryAuthor() + " " + other.getCategoryAuthor());
		}
		if (!(this.getCategoryIndex() == null && other.getCategoryIndex() == null) && !this.getCategoryIndex().equals(other.getCategoryIndex())) {
			differingAttributes.add("categoryIndex: " + this.getCategoryIndex() + " " + other.getCategoryIndex());
		}
		if (!(this.getParentCategoryId() == null && other.getParentCategoryId() == null) && !this.getParentCategoryId().equals(other.getParentCategoryId())) {
			differingAttributes.add("parentCategoryId: " + this.getParentCategoryId() + " " + other.getParentCategoryId());
		}
		if (!(this.getRootCategoryId() == null && other.getRootCategoryId() == null) && !this.getRootCategoryId().equals(other.getRootCategoryId())) {
			differingAttributes.add("rootCategoryId: " + this.getRootCategoryId() + " " + other.getRootCategoryId());
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
		if (!(this.getPublicRootCategory() == null && other.getPublicRootCategory() == null) && !this.getPublicRootCategory().equals(other.getPublicRootCategory())) {
			differingAttributes.add("publicRootCategory: " + this.getPublicRootCategory() + " " + other.getPublicRootCategory());
		}
		return differingAttributes;
	}
	
}

/*       S.D.G.       */
