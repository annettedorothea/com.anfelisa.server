package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestModel;
import com.anfelisa.lesson.models.ILessonIdModel;
import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;
import com.anfelisa.test.models.IMyTestListModel;

@SuppressWarnings("all")
public class MyTestData implements IMyTestData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String testId;
	
	@NotNull
	private String name;
	
	private Integer sequence;
	
	@NotNull
	private String lessonId;
	
	@NotNull
	private String html;
	
	@NotNull
	private String author;
	
	@NotNull
	private String username;
	
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
	
	private java.util.List<com.anfelisa.test.models.IMyTestModel> myTestList;
	

	private org.joda.time.DateTime systemTime;
	
	public MyTestData(
		@JsonProperty("testId") String testId,
		@JsonProperty("name") String name,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("lessonId") String lessonId,
		@JsonProperty("html") String html,
		@JsonProperty("author") String author,
		@JsonProperty("username") String username,
		@JsonProperty("lessonName") String lessonName,
		@JsonProperty("lessonDescription") String lessonDescription,
		@JsonProperty("lessonAuthor") String lessonAuthor,
		@JsonProperty("courseName") String courseName,
		@JsonProperty("courseDescription") String courseDescription,
		@JsonProperty("courseAuthor") String courseAuthor,
		@JsonProperty("courseId") String courseId,
		@JsonProperty("myTestList") java.util.List<com.anfelisa.test.models.IMyTestModel> myTestList
,		@JsonProperty("uuid") String uuid
	) {
		this.testId = testId;
		this.name = name;
		this.sequence = sequence;
		this.lessonId = lessonId;
		this.html = html;
		this.author = author;
		this.username = username;
		this.lessonName = lessonName;
		this.lessonDescription = lessonDescription;
		this.lessonAuthor = lessonAuthor;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseAuthor = courseAuthor;
		this.courseId = courseId;
		this.myTestList = myTestList;
		this.uuid = uuid;
		
	}

	public MyTestData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getTestId() {
		return this.testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public MyTestData withTestId(String testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyTestData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public Integer getSequence() {
		return this.sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public MyTestData withSequence(Integer sequence) {
		this.sequence = sequence;
		return this;
	}
	
	@JsonProperty
	public String getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
	}
	public MyTestData withLessonId(String lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	
	@JsonProperty
	public String getHtml() {
		return this.html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public MyTestData withHtml(String html) {
		this.html = html;
		return this;
	}
	
	@JsonProperty
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public MyTestData withAuthor(String author) {
		this.author = author;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MyTestData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getLessonName() {
		return this.lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public MyTestData withLessonName(String lessonName) {
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
	public MyTestData withLessonDescription(String lessonDescription) {
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
	public MyTestData withLessonAuthor(String lessonAuthor) {
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
	public MyTestData withCourseName(String courseName) {
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
	public MyTestData withCourseDescription(String courseDescription) {
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
	public MyTestData withCourseAuthor(String courseAuthor) {
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
	public MyTestData withCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.test.models.IMyTestModel> getMyTestList() {
		return this.myTestList;
	}
	public void setMyTestList(java.util.List<com.anfelisa.test.models.IMyTestModel> myTestList) {
		this.myTestList = myTestList;
	}
	public MyTestData withMyTestList(java.util.List<com.anfelisa.test.models.IMyTestModel> myTestList) {
		this.myTestList = myTestList;
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
		return new MyTestPresentationalData(
			this.testId,
			this.name,
			this.sequence,
			this.lessonId,
			this.html,
			this.author,
			this.username,
			this.lessonName,
			this.lessonDescription,
			this.lessonAuthor,
			this.courseName,
			this.courseDescription,
			this.courseAuthor,
			this.courseId,
			this.myTestList
		);
	}

}

/*       S.D.G.       */
