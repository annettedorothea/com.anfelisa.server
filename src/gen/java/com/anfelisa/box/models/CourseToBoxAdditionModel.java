package com.anfelisa.box.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CourseToBoxAdditionModel implements ICourseToBoxAdditionModel {

	@NotNull
	private String boxId;
	
	@NotNull
	private String courseId;
	
	@NotNull
	private Boolean autoAdd = false;
	
	@NotNull
	private String name;
	

	public CourseToBoxAdditionModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("courseId") String courseId,
		@JsonProperty("autoAdd") Boolean autoAdd,
		@JsonProperty("name") String name
	) {
		this.boxId = boxId;
		this.courseId = courseId;
		this.autoAdd = autoAdd;
		this.name = name;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	@JsonProperty
	public Boolean getAutoAdd() {
		return this.autoAdd;
	}
	public void setAutoAdd(Boolean autoAdd) {
		this.autoAdd = autoAdd;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}

/*       S.D.G.       */
