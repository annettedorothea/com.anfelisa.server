package com.anfelisa.setup.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.setup.models.ISetupModel;

@SuppressWarnings("unused")
public class SetupData implements ISetupModel, IDataContainer {
	
	private String uuid;
	
	@NotEmpty
	private String schema;
	

	public SetupData(
		@JsonProperty("schema") String schema
,		@JsonProperty("uuid") String uuid
	) {
		this.schema = schema;
		this.uuid = uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	
	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

}

/*       S.D.G.       */
