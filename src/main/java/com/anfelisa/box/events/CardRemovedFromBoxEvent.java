package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.RemoveCardFromBoxData;

public class CardRemovedFromBoxEvent extends AbstractCardRemovedFromBoxEvent {

	static final Logger LOG = LoggerFactory.getLogger(CardRemovedFromBoxEvent.class);

	public CardRemovedFromBoxEvent(RemoveCardFromBoxData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
