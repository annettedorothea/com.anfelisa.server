package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class LineModel implements ILineModel {

	private java.util.List<String> words;
	

	public LineModel(
		@JsonProperty("words") java.util.List<String> words
	) {
		this.words = words;
	}

	@JsonProperty
	public java.util.List<String> getWords() {
		return this.words;
	}
	public void setWords(java.util.List<String> words) {
		this.words = words;
	}
	

}

/*       S.D.G.       */
