package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.IUserWithAccessModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractUserWithAccessData extends AbstractData implements IUserWithAccessData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractUserWithAccessData.class);
	
	@NotNull
	private String userId;
	
	@NotNull
	private String username;
	

	public AbstractUserWithAccessData(
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.username = username;
	}

	public AbstractUserWithAccessData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IUserWithAccessData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IUserWithAccessData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IUserWithAccessModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getUsername() == null && other.getUsername() == null) && !this.getUsername().equals(other.getUsername())) {
			differingAttributes.add("username: " + this.getUsername() + " " + other.getUsername());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
