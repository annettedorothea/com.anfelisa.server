/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.data;

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
public class GetCategoryTreeResponse implements IGetCategoryTreeResponse {
	
	private com.anfelisa.category.models.ICategoryTreeItemModel rootCategory;
	
	private Boolean reverseBoxExists = false;
	
	private String boxId;
	
	public GetCategoryTreeResponse() {
	}
	
	public GetCategoryTreeResponse(com.anfelisa.category.models.ICategoryTreeModel data) {
		rootCategory = data.getRootCategory();
		reverseBoxExists = data.getReverseBoxExists();
		boxId = data.getBoxId();
	}
	
	@JsonProperty
	public com.anfelisa.category.models.ICategoryTreeItemModel getRootCategory() {
		return this.rootCategory;
	}
	
	@JsonProperty
	public Boolean getReverseBoxExists() {
		return this.reverseBoxExists;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	
}



/******* S.D.G. *******/



