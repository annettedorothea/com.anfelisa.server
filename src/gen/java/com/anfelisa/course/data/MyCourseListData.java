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
public class MyCourseListData implements IMyCourseListData {
	
	private String uuid;
	
	private String createdId;
	
	@NotNull
	private String username;
	

	private java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList;
	
	
	private org.joda.time.DateTime systemTime;
	
	public MyCourseListData(
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		this.username = username;
		this.uuid = uuid;
	}

	public MyCourseListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MyCourseListData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.course.models.IMyCourseModel> getMyCourseList() {
		return this.myCourseList;
	}
	public void setMyCourseList(java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList) {
		this.myCourseList = myCourseList;
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

}

/*       S.D.G.       */
