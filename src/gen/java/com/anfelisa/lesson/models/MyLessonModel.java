package com.anfelisa.lesson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class MyLessonModel implements IMyLessonModel {

	@NotNull
	private Integer id;
	
	@NotNull
	private String name;
	
	private String description;
	
	private Integer sequence;
	
	@NotNull
	private Integer openTests;
	
	@NotNull
	private Boolean hasOpenTests;
	


	public MyLessonModel(
		@JsonProperty("id") Integer id,
		@JsonProperty("name") String name,
		@JsonProperty("description") String description,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("openTests") Integer openTests,
		@JsonProperty("hasOpenTests") Boolean hasOpenTests
	) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.sequence = sequence;
		this.openTests = openTests;
		this.hasOpenTests = hasOpenTests;
	}

	@JsonProperty
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
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
	public Integer getOpenTests() {
		return this.openTests;
	}
	public void setOpenTests(Integer openTests) {
		this.openTests = openTests;
	}
	
	@JsonProperty
	public Boolean getHasOpenTests() {
		return this.hasOpenTests;
	}
	public void setHasOpenTests(Boolean hasOpenTests) {
		this.hasOpenTests = hasOpenTests;
	}
	


}

/*       S.D.G.       */
