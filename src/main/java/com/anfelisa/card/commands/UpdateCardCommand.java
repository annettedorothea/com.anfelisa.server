package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.ICardUpdateData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class UpdateCardCommand extends AbstractUpdateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCardCommand.class);

	public UpdateCardCommand(ICardUpdateData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		ICardModel card = daoProvider.getCardDao().selectByCardId(readonlyHandle,  commandData.getCardId());
		if (card == null) {
			throwBadRequest("cardDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(readonlyHandle,  card.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
