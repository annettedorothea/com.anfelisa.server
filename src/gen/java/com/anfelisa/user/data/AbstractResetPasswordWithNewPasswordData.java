package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.user.models.IResetPasswordWithNewPasswordModel;
import com.anfelisa.user.models.IResetPasswordModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractResetPasswordWithNewPasswordData extends AbstractData implements IResetPasswordWithNewPasswordData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractResetPasswordWithNewPasswordData.class);
	
	@NotNull
	private String password;
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	

	public AbstractResetPasswordWithNewPasswordData(
		@JsonProperty("password") String password,
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.password = password;
		this.token = token;
		this.userId = userId;
	}

	public AbstractResetPasswordWithNewPasswordData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public IResetPasswordWithNewPasswordData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public IResetPasswordWithNewPasswordData withToken(String token) {
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
	public IResetPasswordWithNewPasswordData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.user.models.IResetPasswordModel model) {
		this.token = model.getToken();
		this.userId = model.getUserId();
	}
	
	public List<String> equalsPrimitiveTypes(IResetPasswordWithNewPasswordModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getPassword() == null && other.getPassword() == null) && !this.getPassword().equals(other.getPassword())) {
			differingAttributes.add("password: " + this.getPassword() + " " + other.getPassword());
		}
		return differingAttributes;
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
