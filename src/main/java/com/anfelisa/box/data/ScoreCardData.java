package com.anfelisa.box.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreCardData extends AbstractData implements IScoreCardData {
	

	public ScoreCardData(
		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
	}



	@Override
	public Object toPresentationalData() {
		return new ScoreCardPresentationalData(
		);
	}

}

/*       S.D.G.       */
