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
import com.anfelisa.category.models.IUserWithAccessListModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractUserWithAccessListData extends AbstractData implements IUserWithAccessListData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractUserWithAccessListData.class);
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList;
	

	public AbstractUserWithAccessListData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userList") java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.userList = userList;
	}

	public AbstractUserWithAccessListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IUserWithAccessListData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList) {
		this.userList = userList;
	}
	public IUserWithAccessListData withUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList) {
		this.userList = userList;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.category.models.IUserWithAccessListModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		return differingAttributes;
	}
	
	
}




/******* S.D.G. *******/



