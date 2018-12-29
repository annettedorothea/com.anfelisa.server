package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractAvailableData extends AbstractData implements IAvailableData {
	
	private Boolean available = false;
	

	public AbstractAvailableData(
		@JsonProperty("available") Boolean available
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.available = available;
	}

	public AbstractAvailableData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
}

/*       S.D.G.       */
