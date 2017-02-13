package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IReinforceCardListModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.box.models.IBoxModel;

@SuppressWarnings("unused")
public class ReinforceCardListData implements IReinforceCardListData {
	
	private String uuid;
	
	private String schema;
	
	private String createdId;
	
	@NotNull
	private Integer boxId;
	
	@NotNull
	private String boxName;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	

	private java.util.List<com.anfelisa.box.models.IReinforceCardModel> list;
	
	
	

	private org.joda.time.DateTime systemTime;
	
	private boolean replay;

	public ReinforceCardListData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.boxId = boxId;
		this.boxName = boxName;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.name = name;
		this.username = username;
		this.uuid = uuid;
		this.schema = schema;
	}

	public ReinforceCardListData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public ReinforceCardListData withBoxId(Integer boxId) {
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
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IReinforceCardModel> getList() {
		return this.list;
	}
	public void setList(java.util.List<com.anfelisa.box.models.IReinforceCardModel> list) {
		this.list = list;
	}
	
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

	@JsonProperty
	public boolean isReplay() {
		return replay;
	}

	@JsonProperty
	public void setReplay(boolean replay) {
		this.replay = replay;
	}

}

/*       S.D.G.       */
