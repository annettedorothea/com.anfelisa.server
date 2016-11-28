package com.anfelisa.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class TestModel implements ITestModel {

	@NotNull
	private Integer id;
	
	@NotNull
	private String name;
	
	private Integer sequence;
	
	@NotNull
	private Integer lessonId;
	
	@NotNull
	private String html;
	
	@NotNull
	private String author;
	


	public TestModel(
		@JsonProperty("id") Integer id,
		@JsonProperty("name") String name,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("lessonId") Integer lessonId,
		@JsonProperty("html") String html,
		@JsonProperty("author") String author
	) {
		this.id = id;
		this.name = name;
		this.sequence = sequence;
		this.lessonId = lessonId;
		this.html = html;
		this.author = author;
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
	public Integer getSequence() {
		return this.sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	@JsonProperty
	public Integer getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	
	@JsonProperty
	public String getHtml() {
		return this.html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	@JsonProperty
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	


}

/*       S.D.G.       */
