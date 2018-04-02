package com.anfelisa.test.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestIdModel;

@SuppressWarnings("all")
public class TestIdPresentationalData implements ITestIdPresentationalData {
	
	@NotNull
	private String testId;
	
	
	public TestIdPresentationalData(
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
	public TestIdPresentationalData withTestId(String testId) {
		this.testId = testId;
		return this;
	}
	
}

/*       S.D.G.       */
