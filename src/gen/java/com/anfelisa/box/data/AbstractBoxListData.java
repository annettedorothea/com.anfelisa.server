package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IBoxListModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractBoxListData extends AbstractData implements IBoxListData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxListData.class);
	
	private java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList;
	
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	

	public AbstractBoxListData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList,
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxList = boxList;
		this.userId = userId;
		this.today = today;
	}

	public AbstractBoxListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxViewModel> getBoxList() {
		return this.boxList;
	}
	public void setBoxList(java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList) {
		this.boxList = boxList;
	}
	public IBoxListData withBoxList(java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList) {
		this.boxList = boxList;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IBoxListData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public IBoxListData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IBoxListModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getToday() == null && other.getToday() == null) && !this.getToday().equals(other.getToday())) {
			differingAttributes.add("today: " + this.getToday() + " " + other.getToday());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
