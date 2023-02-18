/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;
import de.acegen.AbstractModel;

@SuppressWarnings("all")
public class CardCreationModel extends AbstractModel {

	private String userId;

	private String username;

	private String cardId;

	private String given;

	private String wanted;

	private String cardAuthor;

	private Integer cardIndex;

	private String categoryId;

	private String rootCategoryId;

	private Integer priority;

	
	private Boolean frozen = false;

	public CardCreationModel() {
	}

	public CardCreationModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("cardAuthor") String cardAuthor,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("priority") Integer priority
	) {
		this.userId = userId;
		this.username = username;
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.cardAuthor = cardAuthor;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.priority = priority;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	
	@JsonProperty
	public void setUserId(String userId) {
		if (this.frozen) {
			throw new RuntimeException("userId is frozen");
		}
		this.userId = userId;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	
	@JsonProperty
	public void setUsername(String username) {
		if (this.frozen) {
			throw new RuntimeException("username is frozen");
		}
		this.username = username;
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	
	@JsonProperty
	public void setCardId(String cardId) {
		if (this.frozen) {
			throw new RuntimeException("cardId is frozen");
		}
		this.cardId = cardId;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	
	@JsonProperty
	public void setGiven(String given) {
		if (this.frozen) {
			throw new RuntimeException("given is frozen");
		}
		this.given = given;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	
	@JsonProperty
	public void setWanted(String wanted) {
		if (this.frozen) {
			throw new RuntimeException("wanted is frozen");
		}
		this.wanted = wanted;
	}
	
	@JsonProperty
	public String getCardAuthor() {
		return this.cardAuthor;
	}
	
	@JsonProperty
	public void setCardAuthor(String cardAuthor) {
		if (this.frozen) {
			throw new RuntimeException("cardAuthor is frozen");
		}
		this.cardAuthor = cardAuthor;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	
	@JsonProperty
	public void setCardIndex(Integer cardIndex) {
		if (this.frozen) {
			throw new RuntimeException("cardIndex is frozen");
		}
		this.cardIndex = cardIndex;
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
	public Integer getPriority() {
		return this.priority;
	}
	
	@JsonProperty
	public void setPriority(Integer priority) {
		if (this.frozen) {
			throw new RuntimeException("priority is frozen");
		}
		this.priority = priority;
	}
	
	
	public com.anfelisa.card.models.CardModel mapToCardModel() {
		com.anfelisa.card.models.CardModel model = new com.anfelisa.card.models.CardModel();
		model.setCardId(this.getCardId());
		model.setGiven(this.getGiven());
		model.setWanted(this.getWanted());
		model.setCardAuthor(this.getCardAuthor());
		model.setCardIndex(this.getCardIndex());
		model.setCategoryId(this.getCategoryId());
		model.setRootCategoryId(this.getRootCategoryId());
		model.setPriority(this.getPriority());
		return model;
	}	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public com.anfelisa.card.models.CardCreationModel deepCopy() {
		com.anfelisa.card.models.CardCreationModel copy = new CardCreationModel();
		copy.setUserId(this.getUserId());
		copy.setUsername(this.getUsername());
		copy.setCardId(this.getCardId());
		copy.setGiven(this.getGiven());
		copy.setWanted(this.getWanted());
		copy.setCardAuthor(this.getCardAuthor());
		copy.setCardIndex(this.getCardIndex());
		copy.setCategoryId(this.getCategoryId());
		copy.setRootCategoryId(this.getRootCategoryId());
		copy.setPriority(this.getPriority());
		return copy;
	}
	
	public static CardCreationModel generateTestData() {
		java.util.Random random = new java.util.Random();
		CardCreationModel testData = new CardCreationModel();
		testData.setUserId(randomString(random));
		testData.setUsername(randomString(random));
		testData.setCardId(randomString(random));
		testData.setGiven(randomString(random));
		testData.setWanted(randomString(random));
		testData.setCardAuthor(randomString(random));
		testData.setCardIndex(random.nextInt(50));
		testData.setCategoryId(randomString(random));
		testData.setRootCategoryId(randomString(random));
		testData.setPriority(random.nextInt(50));
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



