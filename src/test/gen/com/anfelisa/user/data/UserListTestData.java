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




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;
import java.util.List;

@SuppressWarnings("unused")
public class UserListTestData {
	
	private String uuid;

	private java.util.List<com.anfelisa.user.data.UserTestData> userList;
	
	private String role;
	

	public UserListTestData(
		@JsonProperty("userList") java.util.List<com.anfelisa.user.data.UserTestData> userList, 
		@JsonProperty("role") String role, 
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
		this.userList = userList;
		this.role = role;
	}

	public UserListTestData(
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
	}

	public UserListTestData() {
	}

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	public java.util.List<com.anfelisa.user.data.UserTestData> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.user.data.UserTestData> userList) {
		this.userList = userList;
	}
	
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}




/******* S.D.G. *******/



