/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;
import de.acegen.AbstractModel;

@SuppressWarnings("unused")
public class BoxModel extends AbstractModel {

	private String boxId;

	private String userId;

	private String categoryId;

	private Integer maxInterval;

	private Integer maxCardsPerDay;

	private Boolean reverse;

	private Boolean archived;

	
	private Boolean frozen = false;

	public BoxModel() {
	}

	public BoxModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay,
		@JsonProperty("reverse") Boolean reverse,
		@JsonProperty("archived") Boolean archived
	) {
		this.boxId = boxId;
		this.userId = userId;
		this.categoryId = categoryId;
		this.maxInterval = maxInterval;
		this.maxCardsPerDay = maxCardsPerDay;
		this.reverse = reverse;
		this.archived = archived;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	
	@JsonProperty
	public void setBoxId(String boxId) {
		if (this.frozen) {
			throw new RuntimeException("boxId is frozen");
		}
		this.boxId = boxId;
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
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	
	@JsonProperty
	public void setMaxInterval(Integer maxInterval) {
		if (this.frozen) {
			throw new RuntimeException("maxInterval is frozen");
		}
		this.maxInterval = maxInterval;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	
	@JsonProperty
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		if (this.frozen) {
			throw new RuntimeException("maxCardsPerDay is frozen");
		}
		this.maxCardsPerDay = maxCardsPerDay;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	
	@JsonProperty
	public void setReverse(Boolean reverse) {
		if (this.frozen) {
			throw new RuntimeException("reverse is frozen");
		}
		this.reverse = reverse;
	}
	
	@JsonProperty
	public Boolean getArchived() {
		return this.archived;
	}
	
	@JsonProperty
	public void setArchived(Boolean archived) {
		if (this.frozen) {
			throw new RuntimeException("archived is frozen");
		}
		this.archived = archived;
	}
	
	
	public com.anfelisa.box.models.MinimalBoxModel mapToMinimalBoxModel() {
		com.anfelisa.box.models.MinimalBoxModel model = new com.anfelisa.box.models.MinimalBoxModel();
		model.setBoxId(this.getBoxId());
		model.setCategoryId(this.getCategoryId());
		model.setReverse(this.getReverse());
		return model;
	}	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public static BoxModel generateTestData() {
		java.util.Random random = new java.util.Random();
		BoxModel testData = new BoxModel();
		testData.setBoxId(randomString(random));
		testData.setUserId(randomString(random));
		testData.setCategoryId(randomString(random));
		testData.setMaxInterval(random.nextInt(50));
		testData.setMaxCardsPerDay(random.nextInt(50));
		testData.setReverse(random.nextBoolean());
		testData.setArchived(random.nextBoolean());
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



