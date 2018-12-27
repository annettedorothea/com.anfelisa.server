package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxListData extends AbstractData implements IBoxListData {
	
	private java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList;
	
	@NotNull
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	

	public BoxListData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList,
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxList = boxList;
		this.userId = userId;
		this.today = today;
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
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BoxListData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public BoxListData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	

}

/*       S.D.G.       */
