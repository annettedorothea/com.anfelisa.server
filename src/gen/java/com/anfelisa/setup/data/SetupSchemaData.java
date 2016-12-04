package com.anfelisa.setup.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.setup.models.ISetupSchemaModel;

@SuppressWarnings("unused")
public class SetupSchemaData implements ISetupSchemaModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotEmpty
	private String schemaToBeCreated;
	

	

	public SetupSchemaData(
		@JsonProperty("schemaToBeCreated") String schemaToBeCreated
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.schemaToBeCreated = schemaToBeCreated;
		this.uuid = uuid;
		this.schema = schema;
	}

	public SetupSchemaData(
		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
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
	public SetupSchemaData withSchemaToBeCreated(String schemaToBeCreated) {
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

}

/*       S.D.G.       */
