package com.anfelisa.lesson.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.IMyLessonListModel;
import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.course.models.ICourseIdModel;
import com.anfelisa.course.models.ICourseAbstractModel;

@SuppressWarnings("all")
public class MyLessonListPresentationalData implements IMyLessonListPresentationalData {
	
	private java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList;
	
	@NotNull
	private String username;
	
	@NotNull
	private Integer courseId;
	
	@NotNull
	private String courseName;
	
	private String courseDescription;
	
	@NotNull
	private Boolean isPublic;
	
	@NotNull
	private String courseAuthor;
	
	
	public MyLessonListPresentationalData(
		@JsonProperty("myLessonList") java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList,
		@JsonProperty("username") String username,
		@JsonProperty("courseId") Integer courseId,
		@JsonProperty("courseName") String courseName,
		@JsonProperty("courseDescription") String courseDescription,
		@JsonProperty("isPublic") Boolean isPublic,
		@JsonProperty("courseAuthor") String courseAuthor
	) {
		this.myLessonList = myLessonList;
		this.username = username;
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.isPublic = isPublic;
		this.courseAuthor = courseAuthor;
		
	}

	@JsonProperty
	public java.util.List<com.anfelisa.lesson.models.IMyLessonModel> getMyLessonList() {
		return this.myLessonList;
	}
	public void setMyLessonList(java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList) {
		this.myLessonList = myLessonList;
	}
	public MyLessonListPresentationalData withMyLessonList(java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList) {
		this.myLessonList = myLessonList;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MyLessonListPresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public MyLessonListPresentationalData withCourseId(Integer courseId) {
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
	public MyLessonListPresentationalData withCourseName(String courseName) {
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
	public MyLessonListPresentationalData withCourseDescription(String courseDescription) {
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
	public MyLessonListPresentationalData withIsPublic(Boolean isPublic) {
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
	public MyLessonListPresentationalData withCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
		return this;
	}
	
}

/*       S.D.G.       */
