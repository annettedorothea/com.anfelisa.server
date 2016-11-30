package com.anfelisa.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class MyTestModel implements IMyTestModel {

	@NotNull
	private Integer testId;
	
	@NotNull
	private String name;
	
	private Integer sequence;
	
	private Integer resultCount;
	
	private Boolean hasResults;
	

	private java.util.List<com.anfelisa.result.models.IResultAbstractModel> resultAbstractList;
	

	public MyTestModel(
		@JsonProperty("testId") Integer testId,
		@JsonProperty("name") String name,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("resultCount") Integer resultCount,
		@JsonProperty("hasResults") Boolean hasResults
	) {
		this.testId = testId;
		this.name = name;
		this.sequence = sequence;
		this.resultCount = resultCount;
		this.hasResults = hasResults;
	}

	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
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
	public Integer getResultCount() {
		return this.resultCount;
	}
	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}
	
	@JsonProperty
	public Boolean getHasResults() {
		return this.hasResults;
	}
	public void setHasResults(Boolean hasResults) {
		this.hasResults = hasResults;
	}
	

	@JsonProperty
	public java.util.List<com.anfelisa.result.models.IResultAbstractModel> getResultAbstractList() {
		return this.resultAbstractList;
	}
	public void setResultAbstractList(java.util.List<com.anfelisa.result.models.IResultAbstractModel> resultAbstractList) {
		this.resultAbstractList = resultAbstractList;
	}
	

}

/*       S.D.G.       */
