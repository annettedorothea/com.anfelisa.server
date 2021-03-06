/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.IUserWithAccessListModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

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
	
	
	
}



/******* S.D.G. *******/



