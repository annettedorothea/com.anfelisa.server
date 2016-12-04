package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestListModel;
import com.anfelisa.test.models.ILessonIdModel;
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;

@SuppressWarnings("unused")
public class TestListData implements ITestListModel, ILessonIdModel, ILessonAbstractModel, ICourseAbstractModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer lessonId;
	
	@NotNull
	private String lessonName;
	
	private String lessonDescription;
	
	@NotNull
	private String lessonAuthor;
	
	@NotNull
	private String courseName;
	
	private String courseDescription;
	
	@NotNull
	private Boolean isPublic;
	
	@NotNull
	private String courseAuthor;
	
	@NotNull
	private Integer courseId;
	

	private java.util.List<com.anfelisa.test.models.ITestModel> testList;
	
	
	
	

	public TestListData(
		@JsonProperty("lessonId") Integer lessonId,
		@JsonProperty("lessonName") String lessonName,
		@JsonProperty("lessonDescription") String lessonDescription,
		@JsonProperty("lessonAuthor") String lessonAuthor,
		@JsonProperty("courseName") String courseName,
		@JsonProperty("courseDescription") String courseDescription,
		@JsonProperty("isPublic") Boolean isPublic,
		@JsonProperty("courseAuthor") String courseAuthor,
		@JsonProperty("courseId") Integer courseId
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.lessonId = lessonId;
		this.lessonName = lessonName;
		this.lessonDescription = lessonDescription;
		this.lessonAuthor = lessonAuthor;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.isPublic = isPublic;
		this.courseAuthor = courseAuthor;
		this.courseId = courseId;
		this.uuid = uuid;
		this.schema = schema;
	}

	public TestListData(
		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public TestListData withLessonId(Integer lessonId) {
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
	public Boolean getIsPublic() {
		return this.isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public TestListData withIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
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
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public TestListData withCourseId(Integer courseId) {
		this.courseId = courseId;
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

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */
