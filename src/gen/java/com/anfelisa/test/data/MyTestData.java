package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.ITestIdModel;
import com.anfelisa.test.models.ILessonIdModel;
import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;
import com.anfelisa.test.models.IMyTestModel;

@SuppressWarnings("unused")
public class MyTestData implements ITestModel, ITestIdModel, ILessonIdModel, IUsernameModel, ILessonAbstractModel, ICourseAbstractModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer id;
	
	@NotNull
	private String name;
	
	private Integer sequence;
	
	@NotNull
	private Integer lessonId;
	
	@NotNull
	private String html;
	
	@NotNull
	private String author;
	
	@NotNull
	private Integer testId;
	
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
	private Boolean isPublic;
	
	@NotNull
	private String courseAuthor;
	
	@NotNull
	private Integer courseId;
	

	java.util.List<IMyTestModel> MyTestList;
	

	
	
	
	
	
	
	private java.util.List<com.anfelisa.result.models.IResultAbstractModel> resultAbstractList;
	

	public MyTestData(
		@JsonProperty("id") Integer id,
		@JsonProperty("name") String name,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("lessonId") Integer lessonId,
		@JsonProperty("html") String html,
		@JsonProperty("author") String author,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("username") String username,
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
		this.id = id;
		this.name = name;
		this.sequence = sequence;
		this.lessonId = lessonId;
		this.html = html;
		this.author = author;
		this.testId = testId;
		this.username = username;
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

	@JsonProperty
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public Integer getSequence() {
		return this.sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	@JsonProperty
	public Integer getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	
	@JsonProperty
	public String getHtml() {
		return this.html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	@JsonProperty
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getLessonName() {
		return this.lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	
	@JsonProperty
	public String getLessonDescription() {
		return this.lessonDescription;
	}
	public void setLessonDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
	}
	
	@JsonProperty
	public String getLessonAuthor() {
		return this.lessonAuthor;
	}
	public void setLessonAuthor(String lessonAuthor) {
		this.lessonAuthor = lessonAuthor;
	}
	
	@JsonProperty
	public String getCourseName() {
		return this.courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@JsonProperty
	public String getCourseDescription() {
		return this.courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	@JsonProperty
	public Boolean getIsPublic() {
		return this.isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	@JsonProperty
	public String getCourseAuthor() {
		return this.courseAuthor;
	}
	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
	}
	
	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	@JsonProperty
	public java.util.List<IMyTestModel> getMyTestList() {
		return this.MyTestList;
	}
	public void setMyTestList(java.util.List<IMyTestModel> MyTestList) {
		this.MyTestList = MyTestList;
	}
	

	
	
	
	
	
	
	@JsonProperty
	public java.util.List<com.anfelisa.result.models.IResultAbstractModel> getResultAbstractList() {
		return this.resultAbstractList;
	}
	public void setResultAbstractList(java.util.List<com.anfelisa.result.models.IResultAbstractModel> resultAbstractList) {
		this.resultAbstractList = resultAbstractList;
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
