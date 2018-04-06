package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseModel;

@SuppressWarnings("all")
public class CourseCreationData implements ICourseCreationData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String courseId;
	
	@NotNull
	private String name;
	
	private String description;
	
	private Integer sequence;
	
	@NotNull
	private String author;
	

	private org.joda.time.DateTime systemTime;
	
	public CourseCreationData(
		@JsonProperty("courseId") String courseId,
		@JsonProperty("name") String name,
		@JsonProperty("description") String description,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("author") String author
,		@JsonProperty("uuid") String uuid
	) {
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.sequence = sequence;
		this.author = author;
		this.uuid = uuid;
		
	}

	public CourseCreationData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public CourseCreationData withCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CourseCreationData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CourseCreationData withDescription(String description) {
		this.description = description;
		return this;
	}
	
	@JsonProperty
	public Integer getSequence() {
		return this.sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public CourseCreationData withSequence(Integer sequence) {
		this.sequence = sequence;
		return this;
	}
	
	@JsonProperty
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public CourseCreationData withAuthor(String author) {
		this.author = author;
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
		return new CourseCreationPresentationalData(
			this.courseId,
			this.name,
			this.description,
			this.sequence,
			this.author
		);
	}

}

/*       S.D.G.       */
