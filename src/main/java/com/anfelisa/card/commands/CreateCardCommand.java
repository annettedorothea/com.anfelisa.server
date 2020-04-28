package com.anfelisa.card.commands;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class CreateCardCommand extends AbstractCreateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardCommand.class);

	public CreateCardCommand(ICardCreationData actionData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		if (StringUtils.isBlank(this.commandData.getGiven())) {
			throwBadRequest("given must not be null or empty or blank");
		}
		if (StringUtils.isBlank(this.commandData.getWanted())) {
			throwBadRequest("wanted must not be null or empty or blank");
		}
		ICategoryModel category = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("category does not exist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, category.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		ICardModel card = this.daoProvider.getCardDao().selectByCardId(readonlyHandle,
				commandData.getUuid());
		if (card != null) {
			throwBadRequest("card with this id already exists");
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
