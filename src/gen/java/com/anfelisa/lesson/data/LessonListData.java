package com.anfelisa.lesson.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.ILessonListModel;
import com.anfelisa.course.models.ICourseIdModel;
import com.anfelisa.course.models.ICourseAbstractModel;

@SuppressWarnings("all")
public class LessonListData implements ILessonListData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	@NotNull
	private Integer courseId;
	
	@NotNull
	private String courseName;
	
	private String courseDescription;
	
	@NotNull
	private Boolean isPublic;
	
	@NotNull
	private String courseAuthor;
	

	private java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList;
	
	
	
	private org.joda.time.DateTime systemTime;
	
	public LessonListData(
		@JsonProperty("courseId") Integer courseId,
		@JsonProperty("courseName") String courseName,
		@JsonProperty("courseDescription") String courseDescription,
		@JsonProperty("isPublic") Boolean isPublic,
		@JsonProperty("courseAuthor") String courseAuthor
,		@JsonProperty("uuid") String uuid
	) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.isPublic = isPublic;
		this.courseAuthor = courseAuthor;
		this.uuid = uuid;
	}

	public LessonListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public LessonListData withCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	@JsonProperty
	public String getCourseName() {
		return this.courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public LessonListData withCourseName(String courseName) {
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
	public LessonListData withCourseDescription(String courseDescription) {
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
	public LessonListData withIsPublic(Boolean isPublic) {
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
	public LessonListData withCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.lesson.models.ILessonModel> getLessonList() {
		return this.lessonList;
	}
	public void setLessonList(java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList) {
		this.lessonList = lessonList;
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
