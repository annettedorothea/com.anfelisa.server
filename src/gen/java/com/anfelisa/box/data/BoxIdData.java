package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxModel;

@SuppressWarnings("unused")
public class BoxIdData implements IBoxModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer boxId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	

	

	public BoxIdData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.boxId = boxId;
		this.name = name;
		this.username = username;
		this.uuid = uuid;
		this.schema = schema;
	}

	public BoxIdData( String uuid,	String schema ) {
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
	public BoxIdData withBoxId(Integer boxId) {
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
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */
