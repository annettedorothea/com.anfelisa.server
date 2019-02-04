package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IDeleteBoxModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractDeleteBoxData extends AbstractData implements IDeleteBoxData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteBoxData.class);
	
	private String userId;
	
	@NotNull
	private String boxId;
	

	public AbstractDeleteBoxData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
	}

	public AbstractDeleteBoxData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IDeleteBoxData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IDeleteBoxData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IDeleteBoxModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
