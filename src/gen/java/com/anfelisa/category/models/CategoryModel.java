/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;
import de.acegen.AbstractModel;

@SuppressWarnings("unused")
public class CategoryModel extends AbstractModel {

	private String categoryId;

	private String categoryName;

	private String categoryAuthor;

	private Integer categoryIndex;

	private String parentCategoryId;

	private String rootCategoryId;

	private Boolean dictionaryLookup;

	private String givenLanguage;

	private String wantedLanguage;

	
	private Boolean frozen = false;

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
		@JsonProperty("wantedLanguage") String wantedLanguage
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
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
	@JsonProperty
	public void setCategoryId(String categoryId) {
		if (this.frozen) {
			throw new RuntimeException("categoryId is frozen");
		}
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	
	@JsonProperty
	public void setCategoryName(String categoryName) {
		if (this.frozen) {
			throw new RuntimeException("categoryName is frozen");
		}
		this.categoryName = categoryName;
	}
	
	@JsonProperty
	public String getCategoryAuthor() {
		return this.categoryAuthor;
	}
	
	@JsonProperty
	public void setCategoryAuthor(String categoryAuthor) {
		if (this.frozen) {
			throw new RuntimeException("categoryAuthor is frozen");
		}
		this.categoryAuthor = categoryAuthor;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	
	@JsonProperty
	public void setCategoryIndex(Integer categoryIndex) {
		if (this.frozen) {
			throw new RuntimeException("categoryIndex is frozen");
		}
		this.categoryIndex = categoryIndex;
	}
	
	@JsonProperty
	public String getParentCategoryId() {
		return this.parentCategoryId;
	}
	
	@JsonProperty
	public void setParentCategoryId(String parentCategoryId) {
		if (this.frozen) {
			throw new RuntimeException("parentCategoryId is frozen");
		}
		this.parentCategoryId = parentCategoryId;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	
	@JsonProperty
	public void setRootCategoryId(String rootCategoryId) {
		if (this.frozen) {
			throw new RuntimeException("rootCategoryId is frozen");
		}
		this.rootCategoryId = rootCategoryId;
	}
	
	@JsonProperty
	public Boolean getDictionaryLookup() {
		return this.dictionaryLookup;
	}
	
	@JsonProperty
	public void setDictionaryLookup(Boolean dictionaryLookup) {
		if (this.frozen) {
			throw new RuntimeException("dictionaryLookup is frozen");
		}
		this.dictionaryLookup = dictionaryLookup;
	}
	
	@JsonProperty
	public String getGivenLanguage() {
		return this.givenLanguage;
	}
	
	@JsonProperty
	public void setGivenLanguage(String givenLanguage) {
		if (this.frozen) {
			throw new RuntimeException("givenLanguage is frozen");
		}
		this.givenLanguage = givenLanguage;
	}
	
	@JsonProperty
	public String getWantedLanguage() {
		return this.wantedLanguage;
	}
	
	@JsonProperty
	public void setWantedLanguage(String wantedLanguage) {
		if (this.frozen) {
			throw new RuntimeException("wantedLanguage is frozen");
		}
		this.wantedLanguage = wantedLanguage;
	}
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public static CategoryModel generateTestData() {
		java.util.Random random = new java.util.Random();
		CategoryModel testData = new CategoryModel();
		testData.setCategoryId(randomString(random));
		testData.setCategoryName(randomString(random));
		testData.setCategoryAuthor(randomString(random));
		testData.setCategoryIndex(random.nextInt(50));
		testData.setParentCategoryId(randomString(random));
		testData.setRootCategoryId(randomString(random));
		testData.setDictionaryLookup(random.nextBoolean());
		testData.setGivenLanguage(randomString(random));
		testData.setWantedLanguage(randomString(random));
		return testData;
	}
	
	private static String randomString(java.util.Random random) {
		String chars = "aaaaaaabcdeeeeeeeffffghiiiiiiijkllllllmmmmnnnnnnnooooooooopqrstttuuuuuuuvxyz";
		int n = random.nextInt(20) + 5;
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		String string  = sb.toString(); 
		return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
	}

}



/******* S.D.G. *******/



