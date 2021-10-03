/********************************************************************************
 * generated by de.acegen 1.5.6
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
import com.anfelisa.box.models.IBoxSettingsWrapperModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractBoxSettingsWrapperData extends AbstractData implements IBoxSettingsWrapperData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxSettingsWrapperData.class);
	
	private String userId;
	
	private String boxId;
	
	private com.anfelisa.box.models.IBoxSettingsModel boxSettings;
	

	public AbstractBoxSettingsWrapperData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxSettings") com.anfelisa.box.models.IBoxSettingsModel boxSettings
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
		this.boxSettings = boxSettings;
	}

	public AbstractBoxSettingsWrapperData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IBoxSettingsWrapperData withUserId(String userId) {
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
	public IBoxSettingsWrapperData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public com.anfelisa.box.models.IBoxSettingsModel getBoxSettings() {
		return this.boxSettings;
	}
	public void setBoxSettings(com.anfelisa.box.models.IBoxSettingsModel boxSettings) {
		this.boxSettings = boxSettings;
	}
	public IBoxSettingsWrapperData withBoxSettings(com.anfelisa.box.models.IBoxSettingsModel boxSettings) {
		this.boxSettings = boxSettings;
		return this;
	}
	
	
	
	public IBoxSettingsWrapperData deepCopy() {
		IBoxSettingsWrapperData copy = new BoxSettingsWrapperData(this.getUuid());
		copy.setUserId(this.getUserId());
		copy.setBoxId(this.getBoxId());
		copy.setBoxSettings(this.getBoxSettings().deepCopy());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



