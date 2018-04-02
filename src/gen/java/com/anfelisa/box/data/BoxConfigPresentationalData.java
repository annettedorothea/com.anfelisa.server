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
public class BoxConfigPresentationalData implements IBoxConfigPresentationalData {
	
	@NotNull
	private String boxId;
	
	private java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList;
	
	private java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems;
	
	@NotNull
	private String username;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	
	public BoxConfigPresentationalData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxOfCourseList") java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList,
		@JsonProperty("existingItems") java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems,
		@JsonProperty("username") String username,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
	) {
		this.boxId = boxId;
		this.boxOfCourseList = boxOfCourseList;
		this.existingItems = existingItems;
		this.username = username;
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
	public BoxConfigPresentationalData withBoxId(String boxId) {
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
	public BoxConfigPresentationalData withBoxOfCourseList(java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList) {
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
	public BoxConfigPresentationalData withExistingItems(java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems) {
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
	public BoxConfigPresentationalData withUsername(String username) {
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
	public BoxConfigPresentationalData withCredentialsUsername(String credentialsUsername) {
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
	public BoxConfigPresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
}

/*       S.D.G.       */
