package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class MyCourseListModel implements IMyCourseListModel {

	private java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList;
	

	public MyCourseListModel(
		@JsonProperty("myCourseList") java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList
	) {
		this.myCourseList = myCourseList;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.course.models.IMyCourseModel> getMyCourseList() {
		return this.myCourseList;
	}
	public void setMyCourseList(java.util.List<com.anfelisa.course.models.IMyCourseModel> myCourseList) {
		this.myCourseList = myCourseList;
	}
	

}

/*       S.D.G.       */
