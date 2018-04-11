package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxOfCourseModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class BoxToCourseAdditionPresentationalData implements IBoxToCourseAdditionPresentationalData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String courseId;
	
	@NotNull
	private Boolean autoAdd = false;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	
	public BoxToCourseAdditionPresentationalData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("courseId") String courseId,
		@JsonProperty("autoAdd") Boolean autoAdd,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
	) {
		this.boxId = boxId;
		this.courseId = courseId;
		this.autoAdd = autoAdd;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public BoxToCourseAdditionPresentationalData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public BoxToCourseAdditionPresentationalData withCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	@JsonProperty
	public Boolean getAutoAdd() {
		return this.autoAdd;
	}
	public void setAutoAdd(Boolean autoAdd) {
		this.autoAdd = autoAdd;
	}
	public BoxToCourseAdditionPresentationalData withAutoAdd(Boolean autoAdd) {
		this.autoAdd = autoAdd;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public BoxToCourseAdditionPresentationalData withCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	public BoxToCourseAdditionPresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
}

/*       S.D.G.       */
