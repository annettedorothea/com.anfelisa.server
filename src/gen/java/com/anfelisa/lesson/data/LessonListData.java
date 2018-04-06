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
	
	private String[] notifiedListeners;
	
	private java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList;
	
	@NotNull
	private String courseId;
	
	@NotNull
	private String courseName;
	
	private String courseDescription;
	
	@NotNull
	private String courseAuthor;
	

	private org.joda.time.DateTime systemTime;
	
	public LessonListData(
		@JsonProperty("lessonList") java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList,
		@JsonProperty("courseId") String courseId,
		@JsonProperty("courseName") String courseName,
		@JsonProperty("courseDescription") String courseDescription,
		@JsonProperty("courseAuthor") String courseAuthor
,		@JsonProperty("uuid") String uuid
	) {
		this.lessonList = lessonList;
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseAuthor = courseAuthor;
		this.uuid = uuid;
		
	}

	public LessonListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.lesson.models.ILessonModel> getLessonList() {
		return this.lessonList;
	}
	public void setLessonList(java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList) {
		this.lessonList = lessonList;
	}
	public LessonListData withLessonList(java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList) {
		this.lessonList = lessonList;
		return this;
	}
	
	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public LessonListData withCourseId(String courseId) {
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
		return new LessonListPresentationalData(
			this.lessonList,
			this.courseId,
			this.courseName,
			this.courseDescription,
			this.courseAuthor
		);
	}

}

/*       S.D.G.       */
