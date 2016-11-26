package com.anfelisa.course.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IMyCourseModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("unused")
public class MyCourseListData implements IUsernameModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private String username;
	

	List<IMyCourseModel> MyCourseList;
	


	public MyCourseListData(
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.username = username;
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public List<IMyCourseModel> getMyCourseList() {
		return this.MyCourseList;
	}
	public void setMyCourseList(List<IMyCourseModel> MyCourseList) {
		this.MyCourseList = MyCourseList;
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
