package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.user.models.IUserPasswordUpdateModel;

@SuppressWarnings("all")
public class PasswordUpdatePresentationalData implements IPasswordUpdatePresentationalData {
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	@NotNull
	private String editedUsername;
	
	@NotNull
	private String newPassword;
	
	
	public PasswordUpdatePresentationalData(
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("editedUsername") String editedUsername,
		@JsonProperty("newPassword") String newPassword
	) {
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.editedUsername = editedUsername;
		this.newPassword = newPassword;
		
	}

	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public PasswordUpdatePresentationalData withCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	public PasswordUpdatePresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public String getEditedUsername() {
		return this.editedUsername;
	}
	public void setEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
	}
	public PasswordUpdatePresentationalData withEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
		return this;
	}
	
	@JsonProperty
	public String getNewPassword() {
		return this.newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public PasswordUpdatePresentationalData withNewPassword(String newPassword) {
		this.newPassword = newPassword;
		return this;
	}
	
}

/*       S.D.G.       */
