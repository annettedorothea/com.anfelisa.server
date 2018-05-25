package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ReinforceCardListPresentationalData implements IReinforceCardListPresentationalData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String boxName;
	
	private java.util.List<com.anfelisa.box.models.IReinforceCardModel> list;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String categoryId;
	
	private Integer maxInterval;
	
	
	public ReinforceCardListPresentationalData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("list") java.util.List<com.anfelisa.box.models.IReinforceCardModel> list,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("userId") String userId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("maxInterval") Integer maxInterval
	) {
		this.boxId = boxId;
		this.boxName = boxName;
		this.list = list;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.userId = userId;
		this.categoryId = categoryId;
		this.maxInterval = maxInterval;
		
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public ReinforceCardListPresentationalData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getBoxName() {
		return this.boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public ReinforceCardListPresentationalData withBoxName(String boxName) {
		this.boxName = boxName;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IReinforceCardModel> getList() {
		return this.list;
	}
	public void setList(java.util.List<com.anfelisa.box.models.IReinforceCardModel> list) {
		this.list = list;
	}
	public ReinforceCardListPresentationalData withList(java.util.List<com.anfelisa.box.models.IReinforceCardModel> list) {
		this.list = list;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public ReinforceCardListPresentationalData withCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	public ReinforceCardListPresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ReinforceCardListPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ReinforceCardListPresentationalData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	public ReinforceCardListPresentationalData withMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
		return this;
	}
	
}

/*       S.D.G.       */
