package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserModel;
import com.anfelisa.course.models.ICourseListModel;
import com.anfelisa.box.models.IMyBoxListModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("all")
public class UserInfoData implements IUserInfoData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String email;
	
	@NotNull
	private String role;
	
	@NotNull
	private Boolean emailConfirmed = false;
	
	@NotNull
	private Boolean deleted = false;
	
	private java.util.List<com.anfelisa.course.models.ICourseModel> courseList;
	
	private java.util.List<com.anfelisa.box.models.IBoxModel> boxList;
	

	private org.joda.time.DateTime systemTime;
	
	public UserInfoData(
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role,
		@JsonProperty("emailConfirmed") Boolean emailConfirmed,
		@JsonProperty("deleted") Boolean deleted,
		@JsonProperty("courseList") java.util.List<com.anfelisa.course.models.ICourseModel> courseList,
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxModel> boxList
,		@JsonProperty("uuid") String uuid
	) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
		this.deleted = deleted;
		this.courseList = courseList;
		this.boxList = boxList;
		this.uuid = uuid;
		
	}

	public UserInfoData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserInfoData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserInfoData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserInfoData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserInfoData withRole(String role) {
		this.role = role;
		return this;
	}
	
	@JsonProperty
	public Boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}
	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	public UserInfoData withEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
		return this;
	}
	
	@JsonProperty
	public Boolean getDeleted() {
		return this.deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public UserInfoData withDeleted(Boolean deleted) {
		this.deleted = deleted;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.course.models.ICourseModel> getCourseList() {
		return this.courseList;
	}
	public void setCourseList(java.util.List<com.anfelisa.course.models.ICourseModel> courseList) {
		this.courseList = courseList;
	}
	public UserInfoData withCourseList(java.util.List<com.anfelisa.course.models.ICourseModel> courseList) {
		this.courseList = courseList;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxModel> getBoxList() {
		return this.boxList;
	}
	public void setBoxList(java.util.List<com.anfelisa.box.models.IBoxModel> boxList) {
		this.boxList = boxList;
	}
	public UserInfoData withBoxList(java.util.List<com.anfelisa.box.models.IBoxModel> boxList) {
		this.boxList = boxList;
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
		return new UserInfoPresentationalData(
			this.username,
			this.password,
			this.email,
			this.role,
			this.emailConfirmed,
			this.deleted,
			this.courseList,
			this.boxList
		);
	}

}

/*       S.D.G.       */
