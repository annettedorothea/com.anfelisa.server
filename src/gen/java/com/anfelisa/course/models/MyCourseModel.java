package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class MyCourseModel implements IMyCourseModel {

	@NotNull
	private Integer courseId;
	
	@NotNull
	private String name;
	
	private String description;
	
	private Integer sequence;
	
	@NotNull
	private Boolean isPublic;
	
	@NotNull
	private String author;
	
	@NotNull
	private Integer openTests;
	
	@NotNull
	private Boolean hasOpenTests;
	

	public MyCourseModel(
		@JsonProperty("courseId") Integer courseId,
		@JsonProperty("name") String name,
		@JsonProperty("description") String description,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("isPublic") Boolean isPublic,
		@JsonProperty("author") String author,
		@JsonProperty("openTests") Integer openTests,
		@JsonProperty("hasOpenTests") Boolean hasOpenTests
	) {
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.sequence = sequence;
		this.isPublic = isPublic;
		this.author = author;
		this.openTests = openTests;
		this.hasOpenTests = hasOpenTests;
	}

	@JsonProperty
	public Integer getCourseId() {
		return this.courseId;
	}
	public void setCourseId(Integer courseId) {
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
	public Boolean getIsPublic() {
		return this.isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
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
