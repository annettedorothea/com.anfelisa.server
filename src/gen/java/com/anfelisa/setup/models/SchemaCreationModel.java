package com.anfelisa.setup.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class SchemaCreationModel implements ISchemaCreationModel {

	@NotEmpty
	private String schemaToBeCreated;
	


	public SchemaCreationModel(
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
