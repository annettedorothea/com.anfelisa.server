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




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.IInviteUserModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractInviteUserData extends AbstractData implements IInviteUserData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractInviteUserData.class);
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String rootCategoryId;
	
	@NotNull
	private String invitedUserId;
	
	@NotNull
	private String invitedUsername;
	
	private Boolean editable = false;
	
	private String userId;
	

	public AbstractInviteUserData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("invitedUserId") String invitedUserId,
		@JsonProperty("invitedUsername") String invitedUsername,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.invitedUserId = invitedUserId;
		this.invitedUsername = invitedUsername;
		this.editable = editable;
		this.userId = userId;
	}

	public AbstractInviteUserData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public String getCategoryId() {
			return this.categoryId;
		}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IInviteUserData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
		public String getRootCategoryId() {
			return this.rootCategoryId;
		}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public IInviteUserData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
		public String getInvitedUserId() {
			return this.invitedUserId;
		}
	public void setInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
	}
	public IInviteUserData withInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
		return this;
	}
	
	@JsonProperty
		public String getInvitedUsername() {
			return this.invitedUsername;
		}
	public void setInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
	}
	public IInviteUserData withInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
		return this;
	}
	
	@JsonProperty
		public Boolean getEditable() {
			return this.editable;
		}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public IInviteUserData withEditable(Boolean editable) {
		this.editable = editable;
		return this;
	}
	
	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IInviteUserData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/



