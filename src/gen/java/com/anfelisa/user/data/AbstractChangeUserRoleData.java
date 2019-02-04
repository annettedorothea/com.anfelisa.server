package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.user.models.IChangeUserRoleModel;

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
	public IChangeUserRoleData withEditedUserId(String editedUserId) {
		this.editedUserId = editedUserId;
		return this;
	}
	
	@JsonProperty
	public String getNewRole() {
		return this.newRole;
	}
	public void setNewRole(String newRole) {
		this.newRole = newRole;
	}
	public IChangeUserRoleData withNewRole(String newRole) {
		this.newRole = newRole;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IChangeUserRoleData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public IChangeUserRoleData withRole(String role) {
		this.role = role;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IChangeUserRoleModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getEditedUserId() == null && other.getEditedUserId() == null) && !this.getEditedUserId().equals(other.getEditedUserId())) {
			differingAttributes.add("editedUserId: " + this.getEditedUserId() + " " + other.getEditedUserId());
		}
		if (!(this.getNewRole() == null && other.getNewRole() == null) && !this.getNewRole().equals(other.getNewRole())) {
			differingAttributes.add("newRole: " + this.getNewRole() + " " + other.getNewRole());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getRole() == null && other.getRole() == null) && !this.getRole().equals(other.getRole())) {
			differingAttributes.add("role: " + this.getRole() + " " + other.getRole());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
