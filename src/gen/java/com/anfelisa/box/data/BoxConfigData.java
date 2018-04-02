package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxConfigModel;
import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class BoxConfigData implements IBoxConfigData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String boxId;
	
	private java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList;
	
	private java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems;
	
	@NotNull
	private String username;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	private org.joda.time.DateTime systemTime;
	
	public BoxConfigData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxOfCourseList") java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList,
		@JsonProperty("existingItems") java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems,
		@JsonProperty("username") String username,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		this.boxId = boxId;
		this.boxOfCourseList = boxOfCourseList;
		this.existingItems = existingItems;
		this.username = username;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.uuid = uuid;
		
	}

	public BoxConfigData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public BoxConfigData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> getBoxOfCourseList() {
		return this.boxOfCourseList;
	}
	public void setBoxOfCourseList(java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList) {
		this.boxOfCourseList = boxOfCourseList;
	}
	public BoxConfigData withBoxOfCourseList(java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList) {
		this.boxOfCourseList = boxOfCourseList;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> getExistingItems() {
		return this.existingItems;
	}
	public void setExistingItems(java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems) {
		this.existingItems = existingItems;
	}
	public BoxConfigData withExistingItems(java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems) {
		this.existingItems = existingItems;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BoxConfigData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public BoxConfigData withCredentialsUsername(String credentialsUsername) {
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
	public BoxConfigData withCredentialsRole(String credentialsRole) {
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
		return new BoxConfigPresentationalData(
			this.boxId,
			this.boxOfCourseList,
			this.existingItems,
			this.username,
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
