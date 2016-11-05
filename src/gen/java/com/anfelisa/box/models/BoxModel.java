package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class BoxModel implements IBoxModel {

	@NotNull
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	

	public BoxModel(
		@JsonProperty("id") Integer id,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username
	) {
		this.id = id;
		this.name = name;
		this.username = username;
	}

	@JsonProperty
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
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
