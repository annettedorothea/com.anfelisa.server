package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICourseToBoxAdditionListModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class BoxOfCourseListData implements IBoxOfCourseListData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String boxName;
	
	private java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	private org.joda.time.DateTime systemTime;
	
	public BoxOfCourseListData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("courseToBoxAdditionList") java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		this.boxId = boxId;
		this.boxName = boxName;
		this.courseToBoxAdditionList = courseToBoxAdditionList;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.uuid = uuid;
		
	}

	public BoxOfCourseListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public BoxOfCourseListData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getBoxName() {
		return this.boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public BoxOfCourseListData withBoxName(String boxName) {
		this.boxName = boxName;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> getCourseToBoxAdditionList() {
		return this.courseToBoxAdditionList;
	}
	public void setCourseToBoxAdditionList(java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList) {
		this.courseToBoxAdditionList = courseToBoxAdditionList;
	}
	public BoxOfCourseListData withCourseToBoxAdditionList(java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList) {
		this.courseToBoxAdditionList = courseToBoxAdditionList;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public BoxOfCourseListData withCredentialsUsername(String credentialsUsername) {
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
	public BoxOfCourseListData withCredentialsRole(String credentialsRole) {
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
		return new BoxOfCourseListPresentationalData(
			this.boxId,
			this.boxName,
			this.courseToBoxAdditionList,
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
