package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICourseIdModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("all")
public class RemoveCourseData implements IRemoveCourseData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	private String courseId;
	
	@NotNull
	private String username;
	

	private org.joda.time.DateTime systemTime;
	
	public RemoveCourseData(
		@JsonProperty("courseId") String courseId,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		this.courseId = courseId;
		this.username = username;
		this.uuid = uuid;
		
	}

	public RemoveCourseData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public RemoveCourseData withCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public RemoveCourseData withUsername(String username) {
		this.username = username;
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
		return new RemoveCoursePresentationalData(
			this.courseId,
			this.username
		);
	}

}

/*       S.D.G.       */
