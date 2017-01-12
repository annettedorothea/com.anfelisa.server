package com.anfelisa.setup.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.setup.models.ISchemaCreationModel;

@SuppressWarnings("unused")
public class SchemaCreationData implements ISchemaCreationData {
	
	private String uuid;
	
	private String schema;
	
	private String createdId;
	
	@NotEmpty
	private String schemaToBeCreated;
	

	

	public SchemaCreationData(
		@JsonProperty("schemaToBeCreated") String schemaToBeCreated
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.schemaToBeCreated = schemaToBeCreated;
		this.uuid = uuid;
		this.schema = schema;
	}

	public SchemaCreationData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public String getSchemaToBeCreated() {
		return this.schemaToBeCreated;
	}
	public void setSchemaToBeCreated(String schemaToBeCreated) {
		this.schemaToBeCreated = schemaToBeCreated;
	}
	public SchemaCreationData withSchemaToBeCreated(String schemaToBeCreated) {
		this.schemaToBeCreated = schemaToBeCreated;
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
