package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class MyCourseModel implements IMyCourseModel {

	@NotNull
	private String courseId;
	
	@NotNull
	private String name;
	
	private String description;
	
	private Integer sequence;
	
	@NotNull
	private String author;
	
	@NotNull
	private Integer openTests;
	
	@NotNull
	private Boolean hasOpenTests;
	

	public MyCourseModel(
		@JsonProperty("courseId") String courseId,
		@JsonProperty("name") String name,
		@JsonProperty("description") String description,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("author") String author,
		@JsonProperty("openTests") Integer openTests,
		@JsonProperty("hasOpenTests") Boolean hasOpenTests
	) {
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.sequence = sequence;
		this.author = author;
		this.openTests = openTests;
		this.hasOpenTests = hasOpenTests;
	}

	@JsonProperty
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
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
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
