package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxIdData extends AbstractData implements IBoxIdData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	public BoxIdData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.name = name;
		this.username = username;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
	}

	public BoxIdData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public BoxIdData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BoxIdData withName(String name) {
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
	public BoxIdData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public BoxIdData withCredentialsUsername(String credentialsUsername) {
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
	public BoxIdData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new BoxIdPresentationalData(
			this.boxId,
			this.name,
			this.username,
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
