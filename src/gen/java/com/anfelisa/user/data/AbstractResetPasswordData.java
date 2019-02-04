package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.user.models.IResetPasswordModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractResetPasswordData extends AbstractData implements IResetPasswordData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractResetPasswordData.class);
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	

	public AbstractResetPasswordData(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.token = token;
		this.userId = userId;
	}

	public AbstractResetPasswordData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public IResetPasswordData withToken(String token) {
		this.token = token;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IResetPasswordData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IResetPasswordModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getToken() == null && other.getToken() == null) && !this.getToken().equals(other.getToken())) {
			differingAttributes.add("token: " + this.getToken() + " " + other.getToken());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
