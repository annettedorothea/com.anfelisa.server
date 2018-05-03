package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.card.data.CardCreationData;
import com.anfelisa.category.models.CategoryDao;

public class CreateCardCommand extends AbstractCreateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardCommand.class);

	private CategoryDao categoryDao = new CategoryDao();
	
	public CreateCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public CreateCardCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (categoryDao.selectByCategoryId(getHandle(), commandData.getCategoryId()) == null) {
			throwBadRequest("category does not exist");
		}
		if (commandData.getCardIndex() == null) {
			commandData.setCardIndex(0);
		}
		this.commandData.setCardId(commandData.getUuid());
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
