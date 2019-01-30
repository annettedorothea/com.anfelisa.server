package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class CreateCardCommand extends AbstractCreateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardCommand.class);

	public CreateCardCommand(ICardCreationData actionData, DatabaseHandle databaseHandle, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(actionData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICategoryModel category = this.daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(getHandle(), category.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		commandData.setRootCategoryId(category.getRootCategoryId());
		this.commandData.setCardId(commandData.getUuid());
		Integer max = this.daoProvider.getCardDao().selectMaxIndexInCategory(getHandle(),
				commandData.getCategoryId());
		if (max == null) {
			max = 0;
		}
		commandData.setCardIndex(max + 1);
		this.commandData.setCardAuthor(commandData.getUsername());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
