package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.ICourseModel;

@SuppressWarnings("unused")
public class CourseListData implements  IDataContainer {
	
	private String uuid;
	
	private String schema;
	

	java.util.List<ICourseModel> CourseList;
	

	

	public CourseListData(
		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public java.util.List<ICourseModel> getCourseList() {
		return this.CourseList;
	}
	public void setCourseList(java.util.List<ICourseModel> CourseList) {
		this.CourseList = CourseList;
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
