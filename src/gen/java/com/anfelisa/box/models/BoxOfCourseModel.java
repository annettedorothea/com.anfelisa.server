package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class BoxOfCourseModel implements IBoxOfCourseModel {

	@NotNull
	private String boxId;
	
	@NotNull
	private String courseId;
	
	@NotNull
	private Boolean autoAdd = false;
	

	public BoxOfCourseModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("courseId") String courseId,
		@JsonProperty("autoAdd") Boolean autoAdd
	) {
		this.boxId = boxId;
		this.courseId = courseId;
		this.autoAdd = autoAdd;
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
	

}

/*       S.D.G.       */
