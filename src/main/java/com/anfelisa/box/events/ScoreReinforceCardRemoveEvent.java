package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScoreReinforceCardData;

public class ScoreReinforceCardRemoveEvent extends AbstractScoreReinforceCardRemoveEvent {

	static final Logger LOG = LoggerFactory.getLogger(ScoreReinforceCardRemoveEvent.class);

	public ScoreReinforceCardRemoveEvent(ScoreReinforceCardData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(eventParam, databaseHandle, daoProvider, viewProvider);
	}

	public ScoreReinforceCardRemoveEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		this(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
