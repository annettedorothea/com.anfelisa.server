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
public class SimpleLessonListPresentationalData implements ISimpleLessonListPresentationalData {
	
	private java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList;
	
	@NotNull
	private String courseId;
	
	
	public SimpleLessonListPresentationalData(
		@JsonProperty("lessonList") java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList,
		@JsonProperty("courseId") String courseId
	) {
		this.lessonList = lessonList;
		this.courseId = courseId;
		
	}

	@JsonProperty
	public java.util.List<com.anfelisa.lesson.models.ILessonModel> getLessonList() {
		return this.lessonList;
	}
	public void setLessonList(java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList) {
		this.lessonList = lessonList;
	}
	public SimpleLessonListPresentationalData withLessonList(java.util.List<com.anfelisa.lesson.models.ILessonModel> lessonList) {
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
	public SimpleLessonListPresentationalData withCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
}

/*       S.D.G.       */
