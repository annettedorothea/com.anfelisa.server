package com.anfelisa.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class MyTestModel implements IMyTestModel {

	@NotNull
	private Integer id;
	
	@NotNull
	private String name;
	
	private Integer sequence;
	
	private Integer resultCount;
	
	private Boolean hasResults;
	

	public MyTestModel(
		@JsonProperty("id") Integer id,
		@JsonProperty("name") String name,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("resultCount") Integer resultCount,
		@JsonProperty("hasResults") Boolean hasResults
	) {
		this.id = id;
		this.name = name;
		this.sequence = sequence;
		this.resultCount = resultCount;
		this.hasResults = hasResults;
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
	

}

/*       S.D.G.       */
