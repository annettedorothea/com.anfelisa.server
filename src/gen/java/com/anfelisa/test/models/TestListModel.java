package com.anfelisa.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class TestListModel implements ITestListModel {

	private java.util.List<com.anfelisa.test.models.ITestModel> testList;
	

	public TestListModel(
		@JsonProperty("testList") java.util.List<com.anfelisa.test.models.ITestModel> testList
	) {
		this.testList = testList;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.test.models.ITestModel> getTestList() {
		return this.testList;
	}
	public void setTestList(java.util.List<com.anfelisa.test.models.ITestModel> testList) {
		this.testList = testList;
	}
	

}

/*       S.D.G.       */
