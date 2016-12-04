package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CardContentModel implements ICardContentModel {

	private Boolean complex;
	
	private String given;
	
	private Boolean large;
	
	private String wanted;
	
	private String header;
	

	private java.util.List<com.anfelisa.box.models.ILineModel> lines;
	

	public CardContentModel(
		@JsonProperty("complex") Boolean complex,
		@JsonProperty("given") String given,
		@JsonProperty("large") Boolean large,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("header") String header
	) {
		this.complex = complex;
		this.given = given;
		this.large = large;
		this.wanted = wanted;
		this.header = header;
	}

	@JsonProperty
	public Boolean getComplex() {
		return this.complex;
	}
	public void setComplex(Boolean complex) {
		this.complex = complex;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	
	@JsonProperty
	public Boolean getLarge() {
		return this.large;
	}
	public void setLarge(Boolean large) {
		this.large = large;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	
	@JsonProperty
	public String getHeader() {
		return this.header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ILineModel> getLines() {
		return this.lines;
	}
	public void setLines(java.util.List<com.anfelisa.box.models.ILineModel> lines) {
		this.lines = lines;
	}
	

}

/*       S.D.G.       */
