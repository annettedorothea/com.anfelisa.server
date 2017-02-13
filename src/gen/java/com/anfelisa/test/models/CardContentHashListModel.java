package com.anfelisa.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CardContentHashListModel implements ICardContentHashListModel {

	private java.util.List<Integer> contentHashList;
	


	public CardContentHashListModel(
		@JsonProperty("contentHashList") java.util.List<Integer> contentHashList
	) {
		this.contentHashList = contentHashList;
	}

	@JsonProperty
	public java.util.List<Integer> getContentHashList() {
		return this.contentHashList;
	}
	public void setContentHashList(java.util.List<Integer> contentHashList) {
		this.contentHashList = contentHashList;
	}
	

		
}

/*       S.D.G.       */
