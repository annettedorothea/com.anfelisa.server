package com.anfelisa.box.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RemoveCardFromBoxData extends AbstractData implements IRemoveCardFromBoxData {
	

	public RemoveCardFromBoxData(
		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
	}



	@Override
	public Object toPresentationalData() {
		return new RemoveCardFromBoxPresentationalData(
		);
	}

}

/*       S.D.G.       */
