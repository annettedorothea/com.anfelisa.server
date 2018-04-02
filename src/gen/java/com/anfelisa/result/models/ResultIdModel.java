package com.anfelisa.result.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ResultIdModel implements IResultIdModel {

	@NotNull
	private String resultId;
	

	public ResultIdModel(
		@JsonProperty("resultId") String resultId
	) {
		this.resultId = resultId;
	}

	@JsonProperty
	public String getResultId() {
		return this.resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	

}

/*       S.D.G.       */
