package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class DeleteUserModel implements IDeleteUserModel {

	@NotNull
	private String deletedUsername;
	

	public DeleteUserModel(
		@JsonProperty("deletedUsername") String deletedUsername
	) {
		this.deletedUsername = deletedUsername;
	}

	@JsonProperty
	public String getDeletedUsername() {
		return this.deletedUsername;
	}
	public void setDeletedUsername(String deletedUsername) {
		this.deletedUsername = deletedUsername;
	}
	

}

/*       S.D.G.       */
