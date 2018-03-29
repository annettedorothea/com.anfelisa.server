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
public class SimpleTestListPresentationalData implements ISimpleTestListPresentationalData {
	
	private java.util.List<com.anfelisa.test.models.ITestModel> testList;
	
	@NotNull
	private Integer lessonId;
	
	
	public SimpleTestListPresentationalData(
		@JsonProperty("testList") java.util.List<com.anfelisa.test.models.ITestModel> testList,
		@JsonProperty("lessonId") Integer lessonId
	) {
		this.testList = testList;
		this.lessonId = lessonId;
		
	}

	@JsonProperty
	public java.util.List<com.anfelisa.test.models.ITestModel> getTestList() {
		return this.testList;
	}
	public void setTestList(java.util.List<com.anfelisa.test.models.ITestModel> testList) {
		this.testList = testList;
	}
	public SimpleTestListPresentationalData withTestList(java.util.List<com.anfelisa.test.models.ITestModel> testList) {
		this.testList = testList;
		return this;
	}
	
	@JsonProperty
	public Integer getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public SimpleTestListPresentationalData withLessonId(Integer lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	
}

/*       S.D.G.       */
