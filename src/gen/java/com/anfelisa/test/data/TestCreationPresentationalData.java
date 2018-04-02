package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestModel;

@SuppressWarnings("all")
public class TestCreationPresentationalData implements ITestCreationPresentationalData {
	
	@NotNull
	private String testId;
	
	@NotNull
	private String name;
	
	private Integer sequence;
	
	@NotNull
	private String lessonId;
	
	@NotNull
	private String html;
	
	@NotNull
	private String author;
	
	
	public TestCreationPresentationalData(
		@JsonProperty("testId") String testId,
		@JsonProperty("name") String name,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("lessonId") String lessonId,
		@JsonProperty("html") String html,
		@JsonProperty("author") String author
	) {
		this.testId = testId;
		this.name = name;
		this.sequence = sequence;
		this.lessonId = lessonId;
		this.html = html;
		this.author = author;
		
	}

	@JsonProperty
	public String getTestId() {
		return this.testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public TestCreationPresentationalData withTestId(String testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TestCreationPresentationalData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public Integer getSequence() {
		return this.sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public TestCreationPresentationalData withSequence(Integer sequence) {
		this.sequence = sequence;
		return this;
	}
	
	@JsonProperty
	public String getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
	}
	public TestCreationPresentationalData withLessonId(String lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	
	@JsonProperty
	public String getHtml() {
		return this.html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public TestCreationPresentationalData withHtml(String html) {
		this.html = html;
		return this;
	}
	
	@JsonProperty
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public TestCreationPresentationalData withAuthor(String author) {
		this.author = author;
		return this;
	}
	
}

/*       S.D.G.       */
