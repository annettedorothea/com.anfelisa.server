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
public class BoxOfCourseListPresentationalData implements IBoxOfCourseListPresentationalData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String boxName;
	
	private java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	
	public BoxOfCourseListPresentationalData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("courseToBoxAdditionList") java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
	) {
		this.boxId = boxId;
		this.boxName = boxName;
		this.courseToBoxAdditionList = courseToBoxAdditionList;
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
	public BoxOfCourseListPresentationalData withBoxId(String boxId) {
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
	public BoxOfCourseListPresentationalData withBoxName(String boxName) {
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
	public BoxOfCourseListPresentationalData withCourseToBoxAdditionList(java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList) {
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
	public BoxOfCourseListPresentationalData withCredentialsUsername(String credentialsUsername) {
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
	public BoxOfCourseListPresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
}

/*       S.D.G.       */
