package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UserPasswordUpdateModel implements IUserPasswordUpdateModel {

	@NotNull
	private String editedUsername;
	
	@NotNull
	private String newPassword;
	

	public UserPasswordUpdateModel(
		@JsonProperty("editedUsername") String editedUsername,
		@JsonProperty("newPassword") String newPassword
	) {
		this.editedUsername = editedUsername;
		this.newPassword = newPassword;
	}

	@JsonProperty
	public String getEditedUsername() {
		return this.editedUsername;
	}
	public void setEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
	}
	
	@JsonProperty
	public String getNewPassword() {
		return this.newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	

}

/*       S.D.G.       */
