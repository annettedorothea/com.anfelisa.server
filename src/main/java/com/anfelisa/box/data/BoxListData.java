package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxListData extends AbstractData implements IBoxListData {
	
	private java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList;
	
	@NotNull
	private String username;
	

	public BoxListData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxList = boxList;
		this.username = username;
	}

	public BoxListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxInfoModel> getBoxList() {
		return this.boxList;
	}
	public void setBoxList(java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList) {
		this.boxList = boxList;
	}
	public BoxListData withBoxList(java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList) {
		this.boxList = boxList;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BoxListData withUsername(String username) {
		this.username = username;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new BoxListPresentationalData(
			this.boxList,
			this.username
		);
	}

}

/*       S.D.G.       */
