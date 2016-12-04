package com.anfelisa.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class MyTestListModel implements IMyTestListModel {


	private java.util.List<com.anfelisa.test.models.IMyTestModel> myTestList;
	

	public MyTestListModel(
	) {
	}


	@JsonProperty
	public java.util.List<com.anfelisa.test.models.IMyTestModel> getMyTestList() {
		return this.myTestList;
	}
	public void setMyTestList(java.util.List<com.anfelisa.test.models.IMyTestModel> myTestList) {
		this.myTestList = myTestList;
	}
	

}

/*       S.D.G.       */
