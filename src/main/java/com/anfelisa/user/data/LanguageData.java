package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageData extends AbstractLanguageData implements ILanguageData {
	
	public LanguageData(
		@JsonProperty("language") String language, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			language,
			uuid
		);
	}

	public LanguageData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
