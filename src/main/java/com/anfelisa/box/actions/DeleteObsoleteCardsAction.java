package com.anfelisa.box.actions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.ContentHashesOfCreatedCardsData;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.ICardModel;

public class DeleteObsoleteCardsAction extends AbstractDeleteObsoleteCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteObsoleteCardsAction.class);

	public DeleteObsoleteCardsAction(ContentHashesOfCreatedCardsData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		List<ICardModel> cardsOfTest = CustomCardDao.selectByTestId(this.getDatabaseHandle().getHandle(), this.actionData.getSchema(), this.actionData.getTestId());
		List<String> contentHashesOfObsoleteCards = new ArrayList<String>();
		for (ICardModel card : cardsOfTest) {
			contentHashesOfObsoleteCards.add(card.getContentHash());
		}
		this.actionData.setContentHashesOfObsoleteCards(contentHashesOfObsoleteCards);
	}

}

/*       S.D.G.       */
