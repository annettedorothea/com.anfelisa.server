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
public class BoxToCourseAdditionData implements IBoxToCourseAdditionData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	@NotNull
	private Integer boxId;
	
	@NotNull
	private Integer courseId;
	
	@NotNull
	private Boolean autoAdd;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	
	
	private org.joda.time.DateTime systemTime;
	
	public BoxToCourseAdditionData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("courseId") Integer courseId,
		@JsonProperty("autoAdd") Boolean autoAdd,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		this.boxId = boxId;
		this.courseId = courseId;
		this.autoAdd = autoAdd;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.uuid = uuid;
	}

	public BoxToCourseAdditionData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public BoxToCourseAdditionData withBoxId(Integer boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public BoxToCourseAdditionData withCourseId(Integer courseId) {
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
	public BoxToCourseAdditionData withAutoAdd(Boolean autoAdd) {
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
	public BoxToCourseAdditionData withCredentialsUsername(String credentialsUsername) {
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
	public BoxToCourseAdditionData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
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

}

/*       S.D.G.       */
