/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IBoxListModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractBoxListData extends AbstractData implements IBoxListData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxListData.class);
	
	private java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList;
	
	private String userId;
	
	private java.time.LocalDateTime todayAtMidnightInUTC;
	

	public AbstractBoxListData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList,
		@JsonProperty("userId") String userId,
		@JsonProperty("todayAtMidnightInUTC") java.time.LocalDateTime todayAtMidnightInUTC
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxList = boxList;
		this.userId = userId;
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
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
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getTodayAtMidnightInUTC() {
		return this.todayAtMidnightInUTC;
	}
	public void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC) {
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
	}
	public IBoxListData withTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC) {
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
		return this;
	}
	
	
	
	public IBoxListData deepCopy() {
		IBoxListData copy = new BoxListData(this.getUuid());
		List<com.anfelisa.box.models.IBoxViewModel> boxListCopy = new ArrayList<com.anfelisa.box.models.IBoxViewModel>();
		for(com.anfelisa.box.models.IBoxViewModel item: this.getBoxList()) {
			boxListCopy.add(item.deepCopy());
		}
		copy.setBoxList(boxListCopy);
		copy.setUserId(this.getUserId());
		copy.setTodayAtMidnightInUTC(this.getTodayAtMidnightInUTC());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



