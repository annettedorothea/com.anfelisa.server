package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICourseToBoxAdditionListModel;
import com.anfelisa.user.models.IUsernameAndPasswordModel;

@SuppressWarnings("unused")
public class BoxOfCourseListData implements ICourseToBoxAdditionListModel, IUsernameAndPasswordModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer boxId;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	

	private java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList;
	
	

	public BoxOfCourseListData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("username") String username,
		@JsonProperty("password") String password
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.boxId = boxId;
		this.username = username;
		this.password = password;
		this.uuid = uuid;
		this.schema = schema;
	}

	public BoxOfCourseListData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public BoxOfCourseListData withBoxId(Integer boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BoxOfCourseListData withUsername(String username) {
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
	public BoxOfCourseListData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> getCourseToBoxAdditionList() {
		return this.courseToBoxAdditionList;
	}
	public void setCourseToBoxAdditionList(java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList) {
		this.courseToBoxAdditionList = courseToBoxAdditionList;
	}
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */
