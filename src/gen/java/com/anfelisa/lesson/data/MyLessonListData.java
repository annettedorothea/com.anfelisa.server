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
public class MyLessonListData implements IMyLessonListData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	private java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList;
	
	@NotNull
	private String username;
	
	@NotNull
	private String courseId;
	
	@NotNull
	private String courseName;
	
	private String courseDescription;
	
	@NotNull
	private Boolean isPublic;
	
	@NotNull
	private String courseAuthor;
	

	private org.joda.time.DateTime systemTime;
	
	public MyLessonListData(
		@JsonProperty("myLessonList") java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList,
		@JsonProperty("username") String username,
		@JsonProperty("courseId") String courseId,
		@JsonProperty("courseName") String courseName,
		@JsonProperty("courseDescription") String courseDescription,
		@JsonProperty("isPublic") Boolean isPublic,
		@JsonProperty("courseAuthor") String courseAuthor
,		@JsonProperty("uuid") String uuid
	) {
		this.myLessonList = myLessonList;
		this.username = username;
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.isPublic = isPublic;
		this.courseAuthor = courseAuthor;
		this.uuid = uuid;
		
	}

	public MyLessonListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.lesson.models.IMyLessonModel> getMyLessonList() {
		return this.myLessonList;
	}
	public void setMyLessonList(java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList) {
		this.myLessonList = myLessonList;
	}
	public MyLessonListData withMyLessonList(java.util.List<com.anfelisa.lesson.models.IMyLessonModel> myLessonList) {
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
	public MyLessonListData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public MyLessonListData withCourseId(String courseId) {
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
	public MyLessonListData withCourseName(String courseName) {
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
	public MyLessonListData withCourseDescription(String courseDescription) {
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
	public MyLessonListData withIsPublic(Boolean isPublic) {
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
	public MyLessonListData withCourseAuthor(String courseAuthor) {
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
		return new MyLessonListPresentationalData(
			this.myLessonList,
			this.username,
			this.courseId,
			this.courseName,
			this.courseDescription,
			this.isPublic,
			this.courseAuthor
		);
	}

}

/*       S.D.G.       */
