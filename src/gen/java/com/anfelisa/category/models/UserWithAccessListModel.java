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
public class UserWithAccessListModel implements IUserWithAccessListModel {

	private String categoryId;
	
	private java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList;
	

	public UserWithAccessListModel() {
	}

	public UserWithAccessListModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userList") java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList
	) {
		this.categoryId = categoryId;
		this.userList = userList;
	}

	@JsonProperty
		public String getCategoryId() {
			return this.categoryId;
		}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
		public java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList() {
			return this.userList;
		}
	public void setUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList) {
		this.userList = userList;
	}
	
	
}




/******* S.D.G. *******/



