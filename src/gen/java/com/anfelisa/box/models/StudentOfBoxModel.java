package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class StudentOfBoxModel implements IStudentOfBoxModel {

	@NotNull
	private Integer studentOfBoxId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	


	public StudentOfBoxModel(
		@JsonProperty("studentOfBoxId") Integer studentOfBoxId,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username
	) {
		this.studentOfBoxId = studentOfBoxId;
		this.name = name;
		this.username = username;
	}

	@JsonProperty
	public Integer getStudentOfBoxId() {
		return this.studentOfBoxId;
	}
	public void setStudentOfBoxId(Integer studentOfBoxId) {
		this.studentOfBoxId = studentOfBoxId;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	


}

/*       S.D.G.       */
