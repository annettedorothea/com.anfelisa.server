package com.anfelisa.test.actions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.test.data.CardContentHashListData;

public class GetCardsOfTestAction extends AbstractGetCardsOfTestAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsOfTestAction.class);

	public GetCardsOfTestAction(CardContentHashListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		List<ICardModel> cards = CustomCardDao.selectByTestId(this.getDatabaseHandle().getHandle(), this.actionData.getSchema(), this.actionData.getTestId());
		List<Integer> contentHashes = new ArrayList<Integer>();
		for (ICardModel card : cards) {
			contentHashes.add(Integer.parseInt(card.getContentHash()));
		}
		this.actionData.setContentHashList(contentHashes);
	}

}

/*       S.D.G.       */
