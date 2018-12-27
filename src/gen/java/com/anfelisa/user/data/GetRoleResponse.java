package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class GetRoleResponse implements IGetRoleResponse {
	
	private String role;
	
	public GetRoleResponse(com.anfelisa.user.models.IRoleModel data) {
		role = data.getRole();
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	
}

/*       S.D.G.       */
