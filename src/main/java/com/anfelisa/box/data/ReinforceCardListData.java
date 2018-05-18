package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReinforceCardListData extends AbstractData implements IReinforceCardListData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String boxName;
	
	private java.util.List<com.anfelisa.box.models.IReinforceCardModel> list;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	

	public ReinforceCardListData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("list") java.util.List<com.anfelisa.box.models.IReinforceCardModel> list,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.boxName = boxName;
		this.list = list;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.name = name;
		this.username = username;
	}

	public ReinforceCardListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public ReinforceCardListData withBoxId(String boxId) {
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
	public ReinforceCardListData withBoxName(String boxName) {
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
	public ReinforceCardListData withList(java.util.List<com.anfelisa.box.models.IReinforceCardModel> list) {
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
	public ReinforceCardListData withCredentialsUsername(String credentialsUsername) {
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
	public ReinforceCardListData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ReinforceCardListData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ReinforceCardListData withUsername(String username) {
		this.username = username;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ReinforceCardListPresentationalData(
			this.boxId,
			this.boxName,
			this.list,
			this.credentialsUsername,
			this.credentialsRole,
			this.name,
			this.username
		);
	}

}

/*       S.D.G.       */