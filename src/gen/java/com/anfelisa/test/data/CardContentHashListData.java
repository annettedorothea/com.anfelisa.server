package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ICardContentHashListModel;
import com.anfelisa.test.models.ITestIdModel;

@SuppressWarnings("unused")
public class CardContentHashListData implements ICardContentHashListData {
	
	private String uuid;
	
	private String schema;
	
	private String createdId;
	
	private java.util.List<Integer> contentHashList;
	
	@NotNull
	private Integer testId;
	

	
	

	private org.joda.time.DateTime systemTime;
	
	private boolean replay;

	public CardContentHashListData(
		@JsonProperty("contentHashList") java.util.List<Integer> contentHashList,
		@JsonProperty("testId") Integer testId
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.contentHashList = contentHashList;
		this.testId = testId;
		this.uuid = uuid;
		this.schema = schema;
	}

	public CardContentHashListData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public java.util.List<Integer> getContentHashList() {
		return this.contentHashList;
	}
	public void setContentHashList(java.util.List<Integer> contentHashList) {
		this.contentHashList = contentHashList;
	}
	public CardContentHashListData withContentHashList(java.util.List<Integer> contentHashList) {
		this.contentHashList = contentHashList;
		return this;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public CardContentHashListData withTestId(Integer testId) {
		this.testId = testId;
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

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

	@JsonProperty
	public boolean isReplay() {
		return replay;
	}

	@JsonProperty
	public void setReplay(boolean replay) {
		this.replay = replay;
	}

}

/*       S.D.G.       */
