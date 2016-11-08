package com.anfelisa.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class TestIdModel implements ITestIdModel {

	@NotNull
	private Integer testId;
	

	public TestIdModel(
		@JsonProperty("testId") Integer testId
	) {
		this.testId = testId;
	}

	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	

}

/*       S.D.G.       */
