package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CourseToBoxAdditionListModel implements ICourseToBoxAdditionListModel {

	@NotNull
	private Integer boxId;
	

	private java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList;
	

	public CourseToBoxAdditionListModel(
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
	public java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> getCourseToBoxAdditionList() {
		return this.courseToBoxAdditionList;
	}
	public void setCourseToBoxAdditionList(java.util.List<com.anfelisa.box.models.ICourseToBoxAdditionModel> courseToBoxAdditionList) {
		this.courseToBoxAdditionList = courseToBoxAdditionList;
	}
	

}

/*       S.D.G.       */
