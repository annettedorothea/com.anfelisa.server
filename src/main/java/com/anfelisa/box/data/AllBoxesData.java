package com.anfelisa.box.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AllBoxesData extends AbstractData implements IAllBoxesData {
	
	private java.util.List<com.anfelisa.box.models.IBoxModel> boxList;
	

	public AllBoxesData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxModel> boxList
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxList = boxList;
	}

	public AllBoxesData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxModel> getBoxList() {
		return this.boxList;
	}
	public void setBoxList(java.util.List<com.anfelisa.box.models.IBoxModel> boxList) {
		this.boxList = boxList;
	}
	public AllBoxesData withBoxList(java.util.List<com.anfelisa.box.models.IBoxModel> boxList) {
		this.boxList = boxList;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new AllBoxesPresentationalData(
			this.boxList
		);
	}

}

/*       S.D.G.       */
