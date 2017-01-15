package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxIdModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("unused")
public class DeleteBoxData implements IDeleteBoxData {
	
	private String uuid;
	
	private String schema;
	
	private String createdId;
	
	@NotNull
	private Integer boxId;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	
	

	public DeleteBoxData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.boxId = boxId;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.uuid = uuid;
		this.schema = schema;
	}

	public DeleteBoxData( String uuid,	String schema ) {
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
	public DeleteBoxData withBoxId(Integer boxId) {
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

}

/*       S.D.G.       */
