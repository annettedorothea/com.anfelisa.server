package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxListModel;
import com.anfelisa.user.models.IUserIdModel;
import com.anfelisa.box.models.ITodayModel;

@SuppressWarnings("all")
public class BoxListPresentationalData implements IBoxListPresentationalData {
	
	private java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList;
	
	@NotNull
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	
	
	public BoxListPresentationalData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList,
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today
	) {
		this.boxList = boxList;
		this.userId = userId;
		this.today = today;
		
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxInfoModel> getBoxList() {
		return this.boxList;
	}
	public void setBoxList(java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList) {
		this.boxList = boxList;
	}
	public BoxListPresentationalData withBoxList(java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList) {
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
	public BoxListPresentationalData withUserId(String userId) {
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
	public BoxListPresentationalData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	
}

/*       S.D.G.       */
