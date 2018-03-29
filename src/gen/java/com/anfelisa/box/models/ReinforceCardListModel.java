package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ReinforceCardListModel implements IReinforceCardListModel {

	@NotNull
	private Integer boxId;
	
	@NotNull
	private String boxName;
	
	private java.util.List<com.anfelisa.box.models.IReinforceCardModel> list;
	

	public ReinforceCardListModel(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("list") java.util.List<com.anfelisa.box.models.IReinforceCardModel> list
	) {
		this.boxId = boxId;
		this.boxName = boxName;
		this.list = list;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public String getBoxName() {
		return this.boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IReinforceCardModel> getList() {
		return this.list;
	}
	public void setList(java.util.List<com.anfelisa.box.models.IReinforceCardModel> list) {
		this.list = list;
	}
	

}

/*       S.D.G.       */
