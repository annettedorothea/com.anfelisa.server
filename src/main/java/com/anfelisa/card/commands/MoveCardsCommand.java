package com.anfelisa.card.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.card.data.IMoveCardsData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class MoveCardsCommand extends AbstractMoveCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(MoveCardsCommand.class);

	public MoveCardsCommand(IMoveCardsData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IUserAccessToCategoryModel accessToCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, commandData.getCategoryId(), commandData.getUserId());
		if (accessToCategory == null || !accessToCategory.getEditable()) {
			throwSecurityException();
		}
		Integer cardIndex = this.daoProvider.getCardDao().selectMaxIndexInCategory(readonlyHandle,
				commandData.getCategoryId());
		if (cardIndex == null) {
			cardIndex = 1;
		} else {
			cardIndex++;
		}
		List<ICardModel> movedCards = new ArrayList<>();
		String sourceCategoryId = "";
		for (String cardId : commandData.getCardIdList()) {
			ICardModel card = daoProvider.getCardDao().selectByCardId(readonlyHandle, cardId);
			if (card == null) {
				throwIllegalArgumentException("cardDoesNotExist");
			}
			IUserAccessToCategoryModel accessToRootCategory = this.daoProvider.getUserAccessToCategoryDao()
					.hasUserAccessTo(readonlyHandle, card.getRootCategoryId(), commandData.getUserId());
			if (accessToRootCategory == null || !accessToRootCategory.getEditable()) {
				throwSecurityException();
			}
			sourceCategoryId = card.getCategoryId();
			card.setCardIndex(cardIndex);
			card.setCategoryId(commandData.getCategoryId());
			movedCards.add(card);
			cardIndex++;
		}
		this.commandData.setMovedCards(movedCards);

		List<ICardModel> updatedIndices = new ArrayList<>();
		cardIndex = 1;
		List<ICardModel> allCardsInSourceCategory = this.daoProvider.getCardDao().selectAll(readonlyHandle,
				sourceCategoryId);
		for (ICardModel card : allCardsInSourceCategory) {
			if (!this.commandData.getCardIdList().contains(card.getCardId())) {
				card.setCardIndex(cardIndex);
				updatedIndices.add(card);
				cardIndex++;
			}
		}
		this.commandData.setUpdatedIndices(updatedIndices);

		this.addOkOutcome();
	}

}

/* S.D.G. */
