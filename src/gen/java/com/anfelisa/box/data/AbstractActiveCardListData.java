/********************************************************************************
 * generated by de.acegen 1.6.0
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
import com.anfelisa.box.models.IActiveCardListModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractActiveCardListData extends AbstractData implements IActiveCardListData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractActiveCardListData.class);
	
	private String userId;
	
	private String boxId;
	
	private java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardList;
	
	private Boolean editable = false;
	

	public AbstractActiveCardListData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("cardList") java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardList,
		@JsonProperty("editable") Boolean editable
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
		this.cardList = cardList;
		this.editable = editable;
	}

	public AbstractActiveCardListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IActiveCardListData withUserId(String userId) {
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
	public IActiveCardListData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardList) {
		this.cardList = cardList;
	}
	public IActiveCardListData withCardList(java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardList) {
		this.cardList = cardList;
		return this;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public IActiveCardListData withEditable(Boolean editable) {
		this.editable = editable;
		return this;
	}
	
	
	
	public IActiveCardListData deepCopy() {
		IActiveCardListData copy = new ActiveCardListData(this.getUuid());
		copy.setUserId(this.getUserId());
		copy.setBoxId(this.getBoxId());
		List<com.anfelisa.box.models.ICardWithStatisticsModel> cardListCopy = new ArrayList<com.anfelisa.box.models.ICardWithStatisticsModel>();
		for(com.anfelisa.box.models.ICardWithStatisticsModel item: this.getCardList()) {
			cardListCopy.add(item.deepCopy());
		}
		copy.setCardList(cardListCopy);
		copy.setEditable(this.getEditable());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



