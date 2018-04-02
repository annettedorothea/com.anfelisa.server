package com.anfelisa.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class TestIdModel implements ITestIdModel {

	@NotNull
	private String testId;
	

	public TestIdModel(
		@JsonProperty("testId") String testId
	) {
		this.testId = testId;
	}

	@JsonProperty
	public String getTestId() {
		return this.testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	

}

/*       S.D.G.       */
