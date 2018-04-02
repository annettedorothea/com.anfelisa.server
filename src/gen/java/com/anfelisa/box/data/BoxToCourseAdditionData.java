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
	
	private String[] notifiedListeners;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String courseId;
	
	@NotNull
	private Boolean autoAdd;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	private org.joda.time.DateTime systemTime;
	
	public BoxToCourseAdditionData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("courseId") String courseId,
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
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public BoxToCourseAdditionData withBoxId(String boxId) {
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
	public BoxToCourseAdditionData withCourseId(String courseId) {
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
		return new BoxToCourseAdditionPresentationalData(
			this.boxId,
			this.courseId,
			this.autoAdd,
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
