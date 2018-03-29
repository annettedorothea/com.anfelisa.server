package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IMyCourseListModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("all")
public class MyCourseListPresentationalData implements IMyCourseListPresentationalData {
	
	private java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList;
	
	@NotNull
	private String username;
	
	
	public MyCourseListPresentationalData(
		@JsonProperty("myCourseList") java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList,
		@JsonProperty("username") String username
	) {
		this.myCourseList = myCourseList;
		this.username = username;
		
	}

	@JsonProperty
	public java.util.List<com.anfelisa.course.models.IMyCourseModel> getMyCourseList() {
		return this.myCourseList;
	}
	public void setMyCourseList(java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList) {
		this.myCourseList = myCourseList;
	}
	public MyCourseListPresentationalData withMyCourseList(java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList) {
		this.myCourseList = myCourseList;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MyCourseListPresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
}

/*       S.D.G.       */
