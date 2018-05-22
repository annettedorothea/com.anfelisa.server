package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IAllBoxesModel;

@SuppressWarnings("all")
public class AllBoxesPresentationalData implements IAllBoxesPresentationalData {
	
	private java.util.List<com.anfelisa.box.models.IBoxModel> boxList;
	
	
	public AllBoxesPresentationalData(
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
	public AllBoxesPresentationalData withBoxList(java.util.List<com.anfelisa.box.models.IBoxModel> boxList) {
		this.boxList = boxList;
		return this;
	}
	
}

/*       S.D.G.       */
