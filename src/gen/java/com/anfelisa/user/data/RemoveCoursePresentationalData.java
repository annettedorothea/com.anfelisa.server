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
public class RemoveCoursePresentationalData implements IRemoveCoursePresentationalData {
	
	private Integer courseId;
	
	@NotNull
	private String username;
	
	
	public RemoveCoursePresentationalData(
		@JsonProperty("courseId") Integer courseId,
		@JsonProperty("username") String username
	) {
		this.courseId = courseId;
		this.username = username;
		
	}

	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public RemoveCoursePresentationalData withCourseId(Integer courseId) {
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
	public RemoveCoursePresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
}

/*       S.D.G.       */
