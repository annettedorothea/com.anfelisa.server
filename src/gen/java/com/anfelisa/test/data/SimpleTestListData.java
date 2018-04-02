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
	
	private String[] notifiedListeners;
	
	private java.util.List<com.anfelisa.test.models.ITestModel> testList;
	
	@NotNull
	private String lessonId;
	

	private org.joda.time.DateTime systemTime;
	
	public SimpleTestListData(
		@JsonProperty("testList") java.util.List<com.anfelisa.test.models.ITestModel> testList,
		@JsonProperty("lessonId") String lessonId
,		@JsonProperty("uuid") String uuid
	) {
		this.testList = testList;
		this.lessonId = lessonId;
		this.uuid = uuid;
		
	}

	public SimpleTestListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.test.models.ITestModel> getTestList() {
		return this.testList;
	}
	public void setTestList(java.util.List<com.anfelisa.test.models.ITestModel> testList) {
		this.testList = testList;
	}
	public SimpleTestListData withTestList(java.util.List<com.anfelisa.test.models.ITestModel> testList) {
		this.testList = testList;
		return this;
	}
	
	@JsonProperty
	public String getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
	}
	public SimpleTestListData withLessonId(String lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
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
		return new SimpleTestListPresentationalData(
			this.testList,
			this.lessonId
		);
	}

}

/*       S.D.G.       */
