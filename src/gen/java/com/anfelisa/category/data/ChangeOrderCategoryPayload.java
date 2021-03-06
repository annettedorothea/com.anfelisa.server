/********************************************************************************
 * generated by de.acegen 1.1.0
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
public class ChangeOrderCategoryPayload implements IChangeOrderCategoryPayload {
	
	private String movedCategoryId;
	
	private String targetCategoryId;
	
	public ChangeOrderCategoryPayload() {
	}
	
	public ChangeOrderCategoryPayload(com.anfelisa.category.models.ICategoryChangeOrderModel data) {
		movedCategoryId = data.getMovedCategoryId();
		targetCategoryId = data.getTargetCategoryId();
	}
	
	@JsonProperty
	public String getMovedCategoryId() {
		return this.movedCategoryId;
	}
	
	@JsonProperty
	public String getTargetCategoryId() {
		return this.targetCategoryId;
	}
	
}



/******* S.D.G. *******/



