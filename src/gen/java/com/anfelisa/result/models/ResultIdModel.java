package com.anfelisa.result.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ResultIdModel implements IResultIdModel {

	@NotNull
	private Integer resultId;
	


	public ResultIdModel(
		@JsonProperty("resultId") Integer resultId
	) {
		this.resultId = resultId;
	}

	@JsonProperty
	public Integer getResultId() {
		return this.resultId;
	}
	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}
	


}

/*       S.D.G.       */
