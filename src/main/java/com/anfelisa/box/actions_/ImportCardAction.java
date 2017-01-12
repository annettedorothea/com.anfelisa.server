package com.anfelisa.box.actions_;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.actions.AbstractImportCardAction;
import com.anfelisa.box.data.CardCreationData;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.ICardModel;

public class ImportCardAction extends AbstractImportCardAction {

	static final Logger LOG = LoggerFactory.getLogger(ImportCardAction.class);

	public ImportCardAction(CardCreationData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
		ICardModel existingCard = CustomCardDao.selectByTestIdAndContentHash(this.getDatabaseHandle().getHandle(), this.actionData.getSchema(),
				this.actionData.getTestId(), this.actionData.getContentHash());
		if (existingCard != null) {
			this.actionData.setCardId(existingCard.getCardId());
		}
	}

}

/*       S.D.G.       */
