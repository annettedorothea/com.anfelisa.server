package com.anfelisa.setup.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class SetupModel implements ISetupModel {

	@NotEmpty
	private String schema;
	

	public SetupModel(
		@JsonProperty("schema") String schema
	) {
		this.schema = schema;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	

}

/*       S.D.G.       */
