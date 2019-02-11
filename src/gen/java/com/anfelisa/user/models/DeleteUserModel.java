/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class DeleteUserModel implements IDeleteUserModel {

	@NotNull
	private String usernameToBeDeleted;
	
	@NotNull
	private String username;
	
	@NotNull
	private String role;
	

	public DeleteUserModel() {
	}

	public DeleteUserModel(
		@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted,
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
	) {
		this.usernameToBeDeleted = usernameToBeDeleted;
		this.username = username;
		this.role = role;
	}

	@JsonProperty
	public String getUsernameToBeDeleted() {
		return this.usernameToBeDeleted;
	}
	public void setUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.user.models.IDeleteUserModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUsernameToBeDeleted() == null && other.getUsernameToBeDeleted() == null) && !this.getUsernameToBeDeleted().equals(other.getUsernameToBeDeleted())) {
			differingAttributes.add("usernameToBeDeleted: " + this.getUsernameToBeDeleted() + " " + other.getUsernameToBeDeleted());
		}
		if (!(this.getUsername() == null && other.getUsername() == null) && !this.getUsername().equals(other.getUsername())) {
			differingAttributes.add("username: " + this.getUsername() + " " + other.getUsername());
		}
		if (!(this.getRole() == null && other.getRole() == null) && !this.getRole().equals(other.getRole())) {
			differingAttributes.add("role: " + this.getRole() + " " + other.getRole());
		}
		return differingAttributes;
	}
	
}




/******* S.D.G. *******/



