package com.anfelisa.card.commands;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.card.data.ICardUpdateData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class UpdateCardCommand extends AbstractUpdateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCardCommand.class);

	public UpdateCardCommand(ICardUpdateData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
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
		ICardModel card = daoProvider.getCardDao().selectByCardId(readonlyHandle,  commandData.getCardId());
		if (card == null) {
			throwBadRequest("card does not exist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(readonlyHandle,  card.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
