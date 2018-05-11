package com.anfelisa.box.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ContentHashModel implements IContentHashModel {

	@NotNull
	private String contentHash;
	

	public ContentHashModel(
		@JsonProperty("contentHash") String contentHash
	) {
		this.contentHash = contentHash;
	}

	@JsonProperty
	public String getContentHash() {
		return this.contentHash;
	}
	public void setContentHash(String contentHash) {
		this.contentHash = contentHash;
	}
	

}

/*       S.D.G.       */
