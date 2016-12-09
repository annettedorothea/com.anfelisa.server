package com.anfelisa.result.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultIdModel;
import com.anfelisa.test.models.ITestIdModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("unused")
public class LastResultIdData implements IResultIdModel, ITestIdModel, IUsernameModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer resultId;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private String username;
	

	
	
	

	public LastResultIdData(
		@JsonProperty("resultId") Integer resultId,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.resultId = resultId;
		this.testId = testId;
		this.username = username;
		this.uuid = uuid;
		this.schema = schema;
	}

	public LastResultIdData(
		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getResultId() {
		return this.resultId;
	}
	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}
	public LastResultIdData withResultId(Integer resultId) {
		this.resultId = resultId;
		return this;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public LastResultIdData withTestId(Integer testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LastResultIdData withUsername(String username) {
		this.username = username;
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

}

/*       S.D.G.       */
