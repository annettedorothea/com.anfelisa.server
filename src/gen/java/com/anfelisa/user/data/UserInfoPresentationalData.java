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
public class UserInfoPresentationalData implements IUserInfoPresentationalData {
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String email;
	
	@NotNull
	private String role;
	
	@NotNull
	private Boolean emailConfirmed;
	
	private java.util.List<com.anfelisa.course.models.ICourseModel> courseList;
	
	private java.util.List<com.anfelisa.box.models.IBoxModel> boxList;
	
	
	public UserInfoPresentationalData(
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role,
		@JsonProperty("emailConfirmed") Boolean emailConfirmed,
		@JsonProperty("courseList") java.util.List<com.anfelisa.course.models.ICourseModel> courseList,
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxModel> boxList
	) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
		this.courseList = courseList;
		this.boxList = boxList;
		
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserInfoPresentationalData withUsername(String username) {
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
	public UserInfoPresentationalData withPassword(String password) {
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
	public UserInfoPresentationalData withEmail(String email) {
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
	public UserInfoPresentationalData withRole(String role) {
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
	public UserInfoPresentationalData withEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.course.models.ICourseModel> getCourseList() {
		return this.courseList;
	}
	public void setCourseList(java.util.List<com.anfelisa.course.models.ICourseModel> courseList) {
		this.courseList = courseList;
	}
	public UserInfoPresentationalData withCourseList(java.util.List<com.anfelisa.course.models.ICourseModel> courseList) {
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
	public UserInfoPresentationalData withBoxList(java.util.List<com.anfelisa.box.models.IBoxModel> boxList) {
		this.boxList = boxList;
		return this;
	}
	
}

/*       S.D.G.       */
