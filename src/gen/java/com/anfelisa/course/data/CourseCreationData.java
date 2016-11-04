package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseModel;

@SuppressWarnings("unused")
public class CourseCreationData implements ICourseModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private Integer sequence;
	
	private Boolean isPublic;
	

	public CourseCreationData(
		@JsonProperty("id") Long id,
		@JsonProperty("name") String name,
		@JsonProperty("description") String description,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("isPublic") Boolean isPublic
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.sequence = sequence;
		this.isPublic = isPublic;
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty
	public Integer getSequence() {
		return this.sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	@JsonProperty
	public Boolean getIsPublic() {
		return this.isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
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
