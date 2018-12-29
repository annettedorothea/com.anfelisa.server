package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class GetBoxesResponse implements IGetBoxesResponse {
	
	private java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList;
	
	public GetBoxesResponse(com.anfelisa.box.models.IBoxListModel data) {
		boxList = data.getBoxList();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxInfoModel> getBoxList() {
		return this.boxList;
	}
	
}

/*       S.D.G.       */
