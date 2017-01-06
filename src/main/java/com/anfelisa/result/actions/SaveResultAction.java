package com.anfelisa.result.actions;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.models.CardOfBoxModel;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;
import com.anfelisa.result.data.ResultSaveData;

public class SaveResultAction extends AbstractSaveResultAction {

	static final Logger LOG = LoggerFactory.getLogger(SaveResultAction.class);

	public SaveResultAction(ResultSaveData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		this.actionParam.setDate(new DateTime(System.currentTimeMillis()));
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		if (this.actionData.getCardsToBeAdded() == null) {
			this.actionData.setCardsToBeAdded(new ArrayList<>());
		}
		;
		List<IBoxModel> boxes = CustomBoxDao.selectBoxesWhereCardMightBeAddedAfterEdit(
				this.getDatabaseHandle().getHandle(), this.actionData.getSchema(), this.actionData.getTestId(),
				this.actionData.getUsername());
		for (IBoxModel box : boxes) {
			List<ICardModel> allCards;
			allCards = CustomCardDao.selectCardsToBeAddedAfterEdit(this.getDatabaseHandle().getHandle(),
					this.actionData.getSchema(), this.actionData.getTestId(), box.getBoxId());
			for (ICardModel card : allCards) {
				ICardOfBoxModel cardOfBox = new CardOfBoxModel(null, card.getCardId(), 0F, 0, 0, 0, this.actionData.getDate(),
						box.getBoxId(), null, this.actionData.getDate(), 0);
				this.actionData.getCardsToBeAdded().add(cardOfBox);
			}

		}
	}

}

/* S.D.G. */
