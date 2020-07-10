/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.6
 *
 */




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.user.models.IDeleteUserModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractDeleteUserData extends AbstractData implements IDeleteUserData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteUserData.class);
	
	private String usernameToBeDeleted;
	
	private String username;
	
	private String userId;
	
	private String role;
	
	private java.util.List<String> boxIds;
	
	private java.util.List<String> rootCategoryIds;
	

	public AbstractDeleteUserData(
		@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted,
		@JsonProperty("username") String username,
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role,
		@JsonProperty("boxIds") java.util.List<String> boxIds,
		@JsonProperty("rootCategoryIds") java.util.List<String> rootCategoryIds
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.usernameToBeDeleted = usernameToBeDeleted;
		this.username = username;
		this.userId = userId;
		this.role = role;
		this.boxIds = boxIds;
		this.rootCategoryIds = rootCategoryIds;
	}

	public AbstractDeleteUserData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsernameToBeDeleted() {
		return this.usernameToBeDeleted;
	}
	public void setUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
	}
	public IDeleteUserData withUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IDeleteUserData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IDeleteUserData withUserId(String userId) {
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
	public IDeleteUserData withRole(String role) {
		this.role = role;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getBoxIds() {
		return this.boxIds;
	}
	public void setBoxIds(java.util.List<String> boxIds) {
		this.boxIds = boxIds;
	}
	public IDeleteUserData withBoxIds(java.util.List<String> boxIds) {
		this.boxIds = boxIds;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getRootCategoryIds() {
		return this.rootCategoryIds;
	}
	public void setRootCategoryIds(java.util.List<String> rootCategoryIds) {
		this.rootCategoryIds = rootCategoryIds;
	}
	public IDeleteUserData withRootCategoryIds(java.util.List<String> rootCategoryIds) {
		this.rootCategoryIds = rootCategoryIds;
		return this;
	}
	
	
	
}



/******* S.D.G. *******/



