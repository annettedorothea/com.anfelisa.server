package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class AllBoxesModel implements IAllBoxesModel {

	private java.util.List<com.anfelisa.box.models.IBoxModel> boxList;
	

	public AllBoxesModel(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxModel> boxList
	) {
		this.boxList = boxList;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxModel> getBoxList() {
		return this.boxList;
	}
	public void setBoxList(java.util.List<com.anfelisa.box.models.IBoxModel> boxList) {
		this.boxList = boxList;
	}
	

}

/*       S.D.G.       */
