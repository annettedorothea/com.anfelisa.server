package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class BoxOfCourseModel implements IBoxOfCourseModel {

	@NotNull
	private Integer boxId;
	
	@NotNull
	private Integer courseId;
	
	@NotNull
	private Boolean autoAdd;
	


	public BoxOfCourseModel(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("courseId") Integer courseId,
		@JsonProperty("autoAdd") Boolean autoAdd
	) {
		this.boxId = boxId;
		this.courseId = courseId;
		this.autoAdd = autoAdd;
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
	

		
}

/*       S.D.G.       */
