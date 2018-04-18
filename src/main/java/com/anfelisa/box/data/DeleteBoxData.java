package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteBoxData extends AbstractData implements IDeleteBoxData {
	
	@NotNull
	private String boxId;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	public DeleteBoxData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
	}

	public DeleteBoxData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public DeleteBoxData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public DeleteBoxData withCredentialsUsername(String credentialsUsername) {
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
	public DeleteBoxData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new DeleteBoxPresentationalData(
			this.boxId,
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
