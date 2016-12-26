package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.user.models.IUsernameAndPasswordModel;

@SuppressWarnings("unused")
public class BoxCreationData implements IBoxModel, IUsernameAndPasswordModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer boxId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	

	
	

	public BoxCreationData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username,
		@JsonProperty("password") String password
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.boxId = boxId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.uuid = uuid;
		this.schema = schema;
	}

	public BoxCreationData( String uuid,	String schema ) {
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
	public BoxCreationData withBoxId(Integer boxId) {
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
	public BoxCreationData withName(String name) {
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
	public BoxCreationData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BoxCreationData withPassword(String password) {
		this.password = password;
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

}

/*       S.D.G.       */
