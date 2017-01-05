package com.anfelisa.box.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.CardIdData;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.ICardModel;

public class DeleteCardAction extends AbstractDeleteCardAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardAction.class);

	public DeleteCardAction(CardIdData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		ICardModel card = CustomCardDao.selectByTestIdAndContentHash(this.getDatabaseHandle().getHandle(), this.actionData.getSchema(),
				this.actionData.getTestId(), this.actionData.getContentHash());
		this.actionData.setCardId(card.getCardId());
	}

}

/* S.D.G. */
