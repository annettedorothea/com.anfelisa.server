package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

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
