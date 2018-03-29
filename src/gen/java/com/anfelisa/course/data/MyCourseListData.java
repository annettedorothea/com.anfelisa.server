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
	
	private String outcome;
	
	private String createdId;
	
	private String[] notifiedListeners;
	
	private java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList;
	
	@NotNull
	private String username;
	

	private org.joda.time.DateTime systemTime;
	
	public MyCourseListData(
		@JsonProperty("myCourseList") java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		this.myCourseList = myCourseList;
		this.username = username;
		this.uuid = uuid;
		
	}

	public MyCourseListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.course.models.IMyCourseModel> getMyCourseList() {
		return this.myCourseList;
	}
	public void setMyCourseList(java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList) {
		this.myCourseList = myCourseList;
	}
	public MyCourseListData withMyCourseList(java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList) {
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
	public MyCourseListData withUsername(String username) {
		this.username = username;
		return this;
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
		return new MyCourseListPresentationalData(
			this.myCourseList,
			this.username
		);
	}

}

/*       S.D.G.       */
