package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CourseToBoxAdditionModel implements ICourseToBoxAdditionModel {

	@NotNull
	private Integer boxId;
	
	@NotNull
	private Integer courseId;
	
	@NotNull
	private Boolean autoAdd;
	
	@NotNull
	private String name;
	


	public CourseToBoxAdditionModel(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("courseId") Integer courseId,
		@JsonProperty("autoAdd") Boolean autoAdd,
		@JsonProperty("name") String name
	) {
		this.boxId = boxId;
		this.courseId = courseId;
		this.autoAdd = autoAdd;
		this.name = name;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
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
