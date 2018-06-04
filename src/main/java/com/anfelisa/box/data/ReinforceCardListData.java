package com.anfelisa.box.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReinforceCardListData extends AbstractData implements IReinforceCardListData {
	

	public ReinforceCardListData(
		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
	}



	@Override
	public Object toPresentationalData() {
		return new ReinforceCardListPresentationalData(
		);
	}

}

/*       S.D.G.       */
