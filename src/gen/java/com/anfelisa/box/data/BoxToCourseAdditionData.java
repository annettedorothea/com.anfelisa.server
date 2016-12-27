package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxOfCourseModel;

@SuppressWarnings("unused")
public class BoxToCourseAdditionData implements IBoxToCourseAdditionData {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer boxId;
	
	@NotNull
	private Integer courseId;
	
	@NotNull
	private Boolean autoAdd;
	

	

	public BoxToCourseAdditionData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("courseId") Integer courseId,
		@JsonProperty("autoAdd") Boolean autoAdd
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.boxId = boxId;
		this.courseId = courseId;
		this.autoAdd = autoAdd;
		this.uuid = uuid;
		this.schema = schema;
	}

	public BoxToCourseAdditionData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public BoxToCourseAdditionData withBoxId(Integer boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public BoxToCourseAdditionData withCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	@JsonProperty
	public Boolean getAutoAdd() {
		return this.autoAdd;
	}
	public void setAutoAdd(Boolean autoAdd) {
		this.autoAdd = autoAdd;
	}
	public BoxToCourseAdditionData withAutoAdd(Boolean autoAdd) {
		this.autoAdd = autoAdd;
		return this;
	}
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */
