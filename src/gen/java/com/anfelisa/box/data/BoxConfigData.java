package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxConfigModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("unused")
public class BoxConfigData implements IBoxConfigData {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer boxId;
	
	@NotNull
	private String username;
	

	private java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList;
	private java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems;
	
	

	public BoxConfigData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.boxId = boxId;
		this.username = username;
		this.uuid = uuid;
		this.schema = schema;
	}

	public BoxConfigData( String uuid,	String schema ) {
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
	public BoxConfigData withBoxId(Integer boxId) {
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
	public BoxConfigData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> getBoxOfCourseList() {
		return this.boxOfCourseList;
	}
	public void setBoxOfCourseList(java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList) {
		this.boxOfCourseList = boxOfCourseList;
	}
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> getExistingItems() {
		return this.existingItems;
	}
	public void setExistingItems(java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems) {
		this.existingItems = existingItems;
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
