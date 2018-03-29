package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ICardContentHashListModel;
import com.anfelisa.test.models.ITestIdModel;

@SuppressWarnings("all")
public class CardContentHashListPresentationalData implements ICardContentHashListPresentationalData {
	
	private java.util.List<Integer> contentHashList;
	
	@NotNull
	private Integer testId;
	
	
	public CardContentHashListPresentationalData(
		@JsonProperty("contentHashList") java.util.List<Integer> contentHashList,
		@JsonProperty("testId") Integer testId
	) {
		this.contentHashList = contentHashList;
		this.testId = testId;
		
	}

	@JsonProperty
	public java.util.List<Integer> getContentHashList() {
		return this.contentHashList;
	}
	public void setContentHashList(java.util.List<Integer> contentHashList) {
		this.contentHashList = contentHashList;
	}
	public CardContentHashListPresentationalData withContentHashList(java.util.List<Integer> contentHashList) {
		this.contentHashList = contentHashList;
		return this;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public CardContentHashListPresentationalData withTestId(Integer testId) {
		this.testId = testId;
		return this;
	}
	
}

/*       S.D.G.       */
