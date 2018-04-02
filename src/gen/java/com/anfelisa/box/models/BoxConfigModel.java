package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class BoxConfigModel implements IBoxConfigModel {

	@NotNull
	private String boxId;
	
	private java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList;
	
	private java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems;
	

	public BoxConfigModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxOfCourseList") java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> boxOfCourseList,
		@JsonProperty("existingItems") java.util.List<com.anfelisa.box.models.IBoxOfCourseModel> existingItems
	) {
		this.boxId = boxId;
		this.boxOfCourseList = boxOfCourseList;
		this.existingItems = existingItems;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
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
	

}

/*       S.D.G.       */
