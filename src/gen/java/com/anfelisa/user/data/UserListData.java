package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserListModel;

@SuppressWarnings("all")
public class UserListData implements IUserListData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	private java.util.List<com.anfelisa.user.models.IUserModel> userList;
	

	private org.joda.time.DateTime systemTime;
	
	public UserListData(
		@JsonProperty("userList") java.util.List<com.anfelisa.user.models.IUserModel> userList
,		@JsonProperty("uuid") String uuid
	) {
		this.userList = userList;
		this.uuid = uuid;
		
	}

	public UserListData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.user.models.IUserModel> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList) {
		this.userList = userList;
	}
	public UserListData withUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList) {
		this.userList = userList;
		return this;
	}
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

	@JsonProperty
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	@JsonProperty
	public String[] getNotifiedListeners() {
		return notifiedListeners;
	}

	@Override
	@JsonProperty
	public void setNotifiedListeners(String[] listeners) {
		this.notifiedListeners = listeners;
	}

	@Override
	public Object toPresentationalData() {
		return new UserListPresentationalData(
			this.userList
		);
	}

}

/*       S.D.G.       */
