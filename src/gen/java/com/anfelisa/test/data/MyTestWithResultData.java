package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.IMyTestModel;

@SuppressWarnings("unused")
public class MyTestWithResultData implements IMyTestModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer id;
	
	@NotNull
	private String name;
	
	private Integer sequence;
	
	private Integer resultCount;
	
	private Boolean hasResults;
	


	List<com.anfelisa.result.data.ResultAbstractData> resultAbstractDataList;
	

	public MyTestWithResultData(
		@JsonProperty("id") Integer id,
		@JsonProperty("name") String name,
		@JsonProperty("sequence") Integer sequence,
		@JsonProperty("resultCount") Integer resultCount,
		@JsonProperty("hasResults") Boolean hasResults
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.id = id;
		this.name = name;
		this.sequence = sequence;
		this.resultCount = resultCount;
		this.hasResults = hasResults;
		this.uuid = uuid;
		this.schema = schema;
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
	
	@JsonProperty
	public List<com.anfelisa.result.data.ResultAbstractData> getResultAbstractDataList() {
		return this.resultAbstractDataList;
	}
	public void setResultAbstractDataList(List<com.anfelisa.result.data.ResultAbstractData> resultAbstractDataList) {
		this.resultAbstractDataList = resultAbstractDataList;
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
