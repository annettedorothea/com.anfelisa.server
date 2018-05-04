package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.models.CategoryDao;

public class CreateCategoryCommand extends AbstractCreateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCategoryCommand.class);

	private CategoryDao categoryDao = new CategoryDao();

	public CreateCategoryCommand(CategoryCreationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCategoryId() != null
				&& categoryDao.selectByCategoryId(getHandle(), commandData.getCategoryId()) == null) {
			throwBadRequest("category does not exist");
		}
		if (commandData.getCategoryIndex() == null) {
			commandData.setCategoryIndex(0);
		}
		this.commandData.setCategoryId(commandData.getUuid());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
