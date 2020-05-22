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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class DeleteUserModel implements IDeleteUserModel {

	private String usernameToBeDeleted;
	
	private String username;
	
	private String userId;
	
	private String role;
	
	private java.util.List<String> boxIds;
	
	private java.util.List<String> rootCategoryIds;
	

	public DeleteUserModel() {
	}

	public DeleteUserModel(
		@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted,
		@JsonProperty("username") String username,
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role,
		@JsonProperty("boxIds") java.util.List<String> boxIds,
		@JsonProperty("rootCategoryIds") java.util.List<String> rootCategoryIds
	) {
		this.usernameToBeDeleted = usernameToBeDeleted;
		this.username = username;
		this.userId = userId;
		this.role = role;
		this.boxIds = boxIds;
		this.rootCategoryIds = rootCategoryIds;
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
	
	@JsonProperty
	public java.util.List<String> getBoxIds() {
		return this.boxIds;
	}
	public void setBoxIds(java.util.List<String> boxIds) {
		this.boxIds = boxIds;
	}
	
	@JsonProperty
	public java.util.List<String> getRootCategoryIds() {
		return this.rootCategoryIds;
	}
	public void setRootCategoryIds(java.util.List<String> rootCategoryIds) {
		this.rootCategoryIds = rootCategoryIds;
	}
	
}
	


/******* S.D.G. *******/



