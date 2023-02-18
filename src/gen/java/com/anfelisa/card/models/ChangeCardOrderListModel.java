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
public class ChangeCardOrderListModel extends AbstractModel {

	private java.util.List<String> cardIdList;

	private String cardId;

	private String userId;

	private java.util.List<com.anfelisa.card.models.CardModel> updatedIndices;

	
	private Boolean frozen = false;

	public ChangeCardOrderListModel() {
	}

	public ChangeCardOrderListModel(
		@JsonProperty("cardIdList") java.util.List<String> cardIdList,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("userId") String userId,
		@JsonProperty("updatedIndices") java.util.List<com.anfelisa.card.models.CardModel> updatedIndices
	) {
		this.cardIdList = cardIdList;
		this.cardId = cardId;
		this.userId = userId;
		this.updatedIndices = updatedIndices;
	}

	@JsonProperty
	public java.util.List<String> getCardIdList() {
		return this.cardIdList;
	}
	
	@JsonProperty
	public void setCardIdList(java.util.List<String> cardIdList) {
		if (this.frozen) {
			throw new RuntimeException("cardIdList is frozen");
		}
		this.cardIdList = cardIdList;
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
	public java.util.List<com.anfelisa.card.models.CardModel> getUpdatedIndices() {
		return this.updatedIndices;
	}
	
	@JsonProperty
	public void setUpdatedIndices(java.util.List<com.anfelisa.card.models.CardModel> updatedIndices) {
		if (this.frozen) {
			throw new RuntimeException("updatedIndices is frozen");
		}
		this.updatedIndices = updatedIndices;
	}
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
		if (this.updatedIndices != null) {
			for ( int i = 0; i < updatedIndices.size(); i++ ) {
				updatedIndices.get(i).freeze();
			}
		}
	}

	public static ChangeCardOrderListModel generateTestData() {
		java.util.Random random = new java.util.Random();
		int n;
		ChangeCardOrderListModel testData = new ChangeCardOrderListModel();
		java.util.List<String> cardIdListList = new java.util.ArrayList<String>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			cardIdListList.add(randomString(random));
		}
		testData.setCardIdList(cardIdListList);
		testData.setCardId(randomString(random));
		testData.setUserId(randomString(random));
		java.util.List<com.anfelisa.card.models.CardModel> updatedIndicesList = new java.util.ArrayList<com.anfelisa.card.models.CardModel>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			updatedIndicesList.add(com.anfelisa.card.models.CardModel.generateTestData());
		}
		testData.setUpdatedIndices(updatedIndicesList);
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



