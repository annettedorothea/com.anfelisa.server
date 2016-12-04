package com.anfelisa.setup.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.setup.models.ISetupModel;

@SuppressWarnings("unused")
public class SetupData implements ISetupModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	

	

	public SetupData(
		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.uuid = uuid;
		this.schema = schema;
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
