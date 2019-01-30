package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class GetUsersWithAccessResponse implements IGetUsersWithAccessResponse {
	
	private java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList;
	
	public GetUsersWithAccessResponse() {
	}
	
	public GetUsersWithAccessResponse(com.anfelisa.category.models.IUserWithAccessListModel data) {
		userList = data.getUserList();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList() {
		return this.userList;
	}
	
}

/*       S.D.G.       */
