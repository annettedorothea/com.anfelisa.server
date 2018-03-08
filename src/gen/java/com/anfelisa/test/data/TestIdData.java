package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestIdModel;

@SuppressWarnings("all")
public class TestIdData implements ITestIdData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	@NotNull
	private Integer testId;
	

	
	private org.joda.time.DateTime systemTime;
	
	public TestIdData(
		@JsonProperty("testId") Integer testId
,		@JsonProperty("uuid") String uuid
	) {
		this.testId = testId;
		this.uuid = uuid;
	}

	public TestIdData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public TestIdData withTestId(Integer testId) {
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

}

/*       S.D.G.       */