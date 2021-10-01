/********************************************************************************
 * generated by de.acegen
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
import com.anfelisa.box.models.IBoxArchiveModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractBoxArchiveData extends AbstractData implements IBoxArchiveData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxArchiveData.class);
	
	private String userId;
	
	private String boxId;
	
	private Boolean archived = false;
	

	public AbstractBoxArchiveData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("archived") Boolean archived
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
		this.archived = archived;
	}

	public AbstractBoxArchiveData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IBoxArchiveData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IBoxArchiveData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Boolean getArchived() {
		return this.archived;
	}
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	public IBoxArchiveData withArchived(Boolean archived) {
		this.archived = archived;
		return this;
	}
	
	
	
	public IBoxArchiveData deepCopy() {
		IBoxArchiveData copy = new BoxArchiveData(this.getUuid());
		copy.setUserId(this.getUserId());
		copy.setBoxId(this.getBoxId());
		copy.setArchived(this.getArchived());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



