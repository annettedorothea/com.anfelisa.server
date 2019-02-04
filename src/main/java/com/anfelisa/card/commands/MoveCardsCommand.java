package com.anfelisa.card.commands;

import java.util.ArrayList;
import java.util.List;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.ICardIdListData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class MoveCardsCommand extends AbstractMoveCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(MoveCardsCommand.class);

	public MoveCardsCommand(ICardIdListData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(actionData, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		IUserAccessToCategoryModel accessToCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle,  commandData.getCategoryId(), commandData.getUserId());
		if (accessToCategory == null) {
			throwUnauthorized();
		}
		Integer cardIndex = this.daoProvider.getCardDao().selectMaxIndexInCategory(readonlyHandle, 
				commandData.getCategoryId());
		if (cardIndex == null) {
			cardIndex = 0;
		} else {
			cardIndex++;
		}
		List<ICardModel> movedCards = new ArrayList<>();
		for (String cardId : commandData.getCardIdList()) {
			ICardModel card = daoProvider.getCardDao().selectByCardId(readonlyHandle,  cardId);
			if (card == null) {
				throwBadRequest("cardDoesNotExist");
			}
			IUserAccessToCategoryModel accessToRootCategory = this.daoProvider.getUserAccessToCategoryDao()
					.hasUserAccessTo(readonlyHandle,  card.getRootCategoryId(), commandData.getUserId());
			if (accessToRootCategory == null) {
				throwUnauthorized();
			}
			card.setCardIndex(cardIndex);
			card.setCategoryId(commandData.getCategoryId());
			movedCards.add(card);
			cardIndex++;
		}
		this.commandData.setMovedCards(movedCards);
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
