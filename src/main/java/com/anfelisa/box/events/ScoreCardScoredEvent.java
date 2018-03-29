package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ScoreCardData;

public class ScoreCardScoredEvent extends AbstractScoreCardScoredEvent {

	static final Logger LOG = LoggerFactory.getLogger(ScoreCardScoredEvent.class);

	public ScoreCardScoredEvent(ScoreCardData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public ScoreCardScoredEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
