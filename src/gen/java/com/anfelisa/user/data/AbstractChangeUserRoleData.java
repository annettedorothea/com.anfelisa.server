package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractChangeUserRoleData extends AbstractData implements IChangeUserRoleData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractChangeUserRoleData.class);
	
	@NotNull
	private String editedUserId;
	
	@NotNull
	private String newRole;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String role;
	

	public AbstractChangeUserRoleData(
		@JsonProperty("editedUserId") String editedUserId,
		@JsonProperty("newRole") String newRole,
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.editedUserId = editedUserId;
		this.newRole = newRole;
		this.userId = userId;
		this.role = role;
	}

	public AbstractChangeUserRoleData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getEditedUserId() {
		return this.editedUserId;
	}
	public void setEditedUserId(String editedUserId) {
		this.editedUserId = editedUserId;
	}
	
	@JsonProperty
	public String getNewRole() {
		return this.newRole;
	}
	public void setNewRole(String newRole) {
		this.newRole = newRole;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}

/*       S.D.G.       */
