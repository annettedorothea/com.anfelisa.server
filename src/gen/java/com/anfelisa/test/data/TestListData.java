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
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;

@SuppressWarnings("all")
public class TestListData implements ITestListData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	private java.util.List<com.anfelisa.test.models.ITestModel> testList;
	
	@NotNull
	private String lessonId;
	
	@NotNull
	private String lessonName;
	
	private String lessonDescription;
	
	@NotNull
	private String lessonAuthor;
	
	@NotNull
	private String courseName;
	
	private String courseDescription;
	
	@NotNull
	private String courseAuthor;
	
	@NotNull
	private String courseId;
	

	private org.joda.time.DateTime systemTime;
	
	public TestListData(
		@JsonProperty("testList") java.util.List<com.anfelisa.test.models.ITestModel> testList,
		@JsonProperty("lessonId") String lessonId,
		@JsonProperty("lessonName") String lessonName,
		@JsonProperty("lessonDescription") String lessonDescription,
		@JsonProperty("lessonAuthor") String lessonAuthor,
		@JsonProperty("courseName") String courseName,
		@JsonProperty("courseDescription") String courseDescription,
		@JsonProperty("courseAuthor") String courseAuthor,
		@JsonProperty("courseId") String courseId
,		@JsonProperty("uuid") String uuid
	) {
		this.testList = testList;
		this.lessonId = lessonId;
		this.lessonName = lessonName;
		this.lessonDescription = lessonDescription;
		this.lessonAuthor = lessonAuthor;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseAuthor = courseAuthor;
		this.courseId = courseId;
		this.uuid = uuid;
		
	}

	public TestListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.test.models.ITestModel> getTestList() {
		return this.testList;
	}
	public void setTestList(java.util.List<com.anfelisa.test.models.ITestModel> testList) {
		this.testList = testList;
	}
	public TestListData withTestList(java.util.List<com.anfelisa.test.models.ITestModel> testList) {
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
	public TestListData withLessonId(String lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	
	@JsonProperty
	public String getLessonName() {
		return this.lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public TestListData withLessonName(String lessonName) {
		this.lessonName = lessonName;
		return this;
	}
	
	@JsonProperty
	public String getLessonDescription() {
		return this.lessonDescription;
	}
	public void setLessonDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
	}
	public TestListData withLessonDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
		return this;
	}
	
	@JsonProperty
	public String getLessonAuthor() {
		return this.lessonAuthor;
	}
	public void setLessonAuthor(String lessonAuthor) {
		this.lessonAuthor = lessonAuthor;
	}
	public TestListData withLessonAuthor(String lessonAuthor) {
		this.lessonAuthor = lessonAuthor;
		return this;
	}
	
	@JsonProperty
	public String getCourseName() {
		return this.courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public TestListData withCourseName(String courseName) {
		this.courseName = courseName;
		return this;
	}
	
	@JsonProperty
	public String getCourseDescription() {
		return this.courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public TestListData withCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
		return this;
	}
	
	@JsonProperty
	public String getCourseAuthor() {
		return this.courseAuthor;
	}
	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
	}
	public TestListData withCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
		return this;
	}
	
	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public TestListData withCourseId(String courseId) {
		this.courseId = courseId;
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
		return new TestListPresentationalData(
			this.testList,
			this.lessonId,
			this.lessonName,
			this.lessonDescription,
			this.lessonAuthor,
			this.courseName,
			this.courseDescription,
			this.courseAuthor,
			this.courseId
		);
	}

}

/*       S.D.G.       */
