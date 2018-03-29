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

@SuppressWarnings("all")
public class CardContentHashListData implements ICardContentHashListData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	private String[] notifiedListeners;
	
	private java.util.List<Integer> contentHashList;
	
	@NotNull
	private Integer testId;
	

	private org.joda.time.DateTime systemTime;
	
	public CardContentHashListData(
		@JsonProperty("contentHashList") java.util.List<Integer> contentHashList,
		@JsonProperty("testId") Integer testId
,		@JsonProperty("uuid") String uuid
	) {
		this.contentHashList = contentHashList;
		this.testId = testId;
		this.uuid = uuid;
		
	}

	public CardContentHashListData( String uuid ) {
		this.uuid = uuid;
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
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	@JsonProperty
	public String[] getNotifiedListeners() {
		return notifiedListeners;
	}

	@Override
	@JsonProperty
	public void setNotifiedListeners(String[] listeners) {
		this.notifiedListeners = listeners;
	}

	@Override
	public Object toPresentationalData() {
		return new CardContentHashListPresentationalData(
			this.contentHashList,
			this.testId
		);
	}

}

/*       S.D.G.       */
