/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;
import de.acegen.AbstractModel;

@SuppressWarnings("unused")
public class CardUpdateModel extends AbstractModel {

	private String cardId;

	private String given;

	private String wanted;

	private String userId;

	
	private Boolean frozen = false;

	public CardUpdateModel() {
	}

	public CardUpdateModel(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("userId") String userId
	) {
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.userId = userId;
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
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public static CardUpdateModel generateTestData() {
		java.util.Random random = new java.util.Random();
		CardUpdateModel testData = new CardUpdateModel();
		testData.setCardId(randomString(random));
		testData.setGiven(randomString(random));
		testData.setWanted(randomString(random));
		testData.setUserId(randomString(random));
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



