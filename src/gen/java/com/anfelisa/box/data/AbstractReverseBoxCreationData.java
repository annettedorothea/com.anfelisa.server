/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IReverseBoxCreationModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractReverseBoxCreationData extends AbstractData implements IReverseBoxCreationData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractReverseBoxCreationData.class);
	
	private String boxId;
	
	private String username;
	

	public AbstractReverseBoxCreationData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.username = username;
	}

	public AbstractReverseBoxCreationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IReverseBoxCreationData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IReverseBoxCreationData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	
	
	public IReverseBoxCreationData deepCopy() {
		IReverseBoxCreationData copy = new ReverseBoxCreationData(this.getUuid());
		copy.setBoxId(this.getBoxId());
		copy.setUsername(this.getUsername());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



