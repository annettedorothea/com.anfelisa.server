package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestListModel;
import com.anfelisa.lesson.models.ILessonIdModel;

@SuppressWarnings("all")
public class SimpleTestListData implements ISimpleTestListData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	@NotNull
	private Integer lessonId;
	

	private java.util.List<com.anfelisa.test.models.ITestModel> testList;
	
	
	private org.joda.time.DateTime systemTime;
	
	public SimpleTestListData(
		@JsonProperty("lessonId") Integer lessonId
,		@JsonProperty("uuid") String uuid
	) {
		this.lessonId = lessonId;
		this.uuid = uuid;
	}

	public SimpleTestListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public SimpleTestListData withLessonId(Integer lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.test.models.ITestModel> getTestList() {
		return this.testList;
	}
	public void setTestList(java.util.List<com.anfelisa.test.models.ITestModel> testList) {
		this.testList = testList;
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
