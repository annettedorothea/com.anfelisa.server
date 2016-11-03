package com.anfelisa.setup.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class SetupSchemaModel implements ISetupSchemaModel {

	@NotEmpty
	private String schemaToBeCreated;
	

	public SetupSchemaModel(
		@JsonProperty("schemaToBeCreated") String schemaToBeCreated
	) {
		this.schemaToBeCreated = schemaToBeCreated;
	}

	@JsonProperty
	public String getSchemaToBeCreated() {
		return this.schemaToBeCreated;
	}
	public void setSchemaToBeCreated(String schemaToBeCreated) {
		this.schemaToBeCreated = schemaToBeCreated;
	}
	

}

/*       S.D.G.       */
