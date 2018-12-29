package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractBoxListData extends AbstractData implements IBoxListData {
	
	private java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList;
	
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	

	public AbstractBoxListData(
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

	public AbstractBoxListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxInfoModel> getBoxList() {
		return this.boxList;
	}
	public void setBoxList(java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList) {
		this.boxList = boxList;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	
}

/*       S.D.G.       */
