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




package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InviteUserModel implements IInviteUserModel {

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
	

	public InviteUserModel() {
	}

	public InviteUserModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("invitedUserId") String invitedUserId,
		@JsonProperty("invitedUsername") String invitedUsername,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("userId") String userId
	) {
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.invitedUserId = invitedUserId;
		this.invitedUsername = invitedUsername;
		this.editable = editable;
		this.userId = userId;
	}

	@JsonProperty
		public String getCategoryId() {
			return this.categoryId;
		}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
		public String getRootCategoryId() {
			return this.rootCategoryId;
		}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	
	@JsonProperty
		public String getInvitedUserId() {
			return this.invitedUserId;
		}
	public void setInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
	}
	
	@JsonProperty
		public String getInvitedUsername() {
			return this.invitedUsername;
		}
	public void setInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
	}
	
	@JsonProperty
		public Boolean getEditable() {
			return this.editable;
		}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	
	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}




/******* S.D.G. *******/



