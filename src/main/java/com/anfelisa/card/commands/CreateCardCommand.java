package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.CardCreationData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class CreateCardCommand extends AbstractCreateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardCommand.class);

	public CreateCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (daoProvider.getCategoryDao().selectByCategoryId(getHandle(), commandData.getCategoryId()) == null) {
			throwBadRequest("category does not exist");
		}
		if (commandData.getCategoryId() != null) {
			ICategoryModel category = this.daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
					commandData.getCategoryId());
			IUserAccessToCategoryModel access = this.daoProvider.getCustomUserAccessToCategoryDao().selectByCategoryIdAndUserId(getHandle(), category.getRootCategoryId(), commandData.getUserId());
			if (access == null) {
				throwUnauthorized();
			}
			commandData.setRootCategoryId(category.getRootCategoryId());
			commandData.setPath(category.getPath());
		} else {
			throwBadRequest("cannot create card without category");
		}
		this.commandData.setCardId(commandData.getUuid());
		if (commandData.getCardIndex() == null) {
			Integer max = this.daoProvider.getCustomCardDao().selectMaxIndexInCategory(getHandle(),
					commandData.getCategoryId());
			if (max == null) {
				max = 0;
			}
			commandData.setCardIndex(max + 1);
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
