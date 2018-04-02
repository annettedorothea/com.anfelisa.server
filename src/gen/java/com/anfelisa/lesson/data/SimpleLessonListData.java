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

@SuppressWarnings("all")
public class SimpleLessonListData implements ISimpleLessonListData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	private java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList;
	
	@NotNull
	private String courseId;
	

	private org.joda.time.DateTime systemTime;
	
	public SimpleLessonListData(
		@JsonProperty("lessonList") java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList,
		@JsonProperty("courseId") String courseId
,		@JsonProperty("uuid") String uuid
	) {
		this.lessonList = lessonList;
		this.courseId = courseId;
		this.uuid = uuid;
		
	}

	public SimpleLessonListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.lesson.models.ILessonModel> getLessonList() {
		return this.lessonList;
	}
	public void setLessonList(java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList) {
		this.lessonList = lessonList;
	}
	public SimpleLessonListData withLessonList(java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList) {
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
	public SimpleLessonListData withCourseId(String courseId) {
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
		return new SimpleLessonListPresentationalData(
			this.lessonList,
			this.courseId
		);
	}

}

/*       S.D.G.       */
