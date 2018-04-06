package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxListModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("all")
public class BoxListPresentationalData implements IBoxListPresentationalData {
	
	private java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList;
	
	@NotNull
	private String username;
	
	
	public BoxListPresentationalData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList,
		@JsonProperty("username") String username
	) {
		this.boxList = boxList;
		this.username = username;
		
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
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BoxListPresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
}

/*       S.D.G.       */