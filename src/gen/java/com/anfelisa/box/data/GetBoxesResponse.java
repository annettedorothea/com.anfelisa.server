/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class GetBoxesResponse implements IGetBoxesResponse {
	
	private java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList;
	
	public GetBoxesResponse() {
	}
	
	public GetBoxesResponse(com.anfelisa.box.models.IBoxListModel data) {
		boxList = data.getBoxList();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxViewModel> getBoxList() {
		return this.boxList;
	}
	
}



/******* S.D.G. *******/



