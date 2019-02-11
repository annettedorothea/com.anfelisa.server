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
public class ChangeUserRoleModel implements IChangeUserRoleModel {

	@NotNull
	private String editedUserId;
	
	@NotNull
	private String newRole;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String role;
	

	public ChangeUserRoleModel() {
	}

	public ChangeUserRoleModel(
		@JsonProperty("editedUserId") String editedUserId,
		@JsonProperty("newRole") String newRole,
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role
	) {
		this.editedUserId = editedUserId;
		this.newRole = newRole;
		this.userId = userId;
		this.role = role;
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
	
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.user.models.IChangeUserRoleModel other) {
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




/******* S.D.G. *******/



