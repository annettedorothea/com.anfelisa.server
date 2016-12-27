package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class BoxConfigModel implements IBoxConfigModel {

	@NotNull
	private Integer boxId;
	

	private java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList;
	

	public BoxConfigModel(
		@JsonProperty("boxId") Integer boxId
	) {
		this.boxId = boxId;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> getBoxOfCourseList() {
		return this.boxOfCourseList;
	}
	public void setBoxOfCourseList(java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList) {
		this.boxOfCourseList = boxOfCourseList;
	}
	

}

/*       S.D.G.       */
