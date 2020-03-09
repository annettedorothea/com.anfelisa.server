package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class CreateCardCommand extends AbstractCreateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardCommand.class);

	public CreateCardCommand(ICardCreationData actionData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		ICategoryModel category = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, category.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		commandData.setRootCategoryId(category.getRootCategoryId());
		this.commandData.setCardId(commandData.getUuid());
		Integer max = this.daoProvider.getCardDao().selectMaxIndexInCategory(readonlyHandle,
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
