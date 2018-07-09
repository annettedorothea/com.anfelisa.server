package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.CardDeleteData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class DeleteCardCommand extends AbstractDeleteCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardCommand.class);

	public DeleteCardCommand(CardDeleteData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICardModel card = daoProvider.getCardDao().selectByCardId(getHandle(), commandData.getCardId());
		if (card == null) {
			throwBadRequest("card does not exist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getCustomUserAccessToCategoryDao().selectByCategoryIdAndUserId(getHandle(), card.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		this.commandData.setCardIndex(card.getCardIndex());
		this.commandData.setCategoryId(card.getCategoryId());
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
