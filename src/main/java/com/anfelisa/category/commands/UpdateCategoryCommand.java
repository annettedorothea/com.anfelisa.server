package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.category.data.CategoryUpdateData;
import com.anfelisa.category.models.CategoryDao;

public class UpdateCategoryCommand extends AbstractUpdateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCategoryCommand.class);

	private CategoryDao categoryDao = new CategoryDao();

	public UpdateCategoryCommand(CategoryUpdateData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		if (categoryDao.selectByCategoryId(getHandle(), commandData.getCategoryId()) == null) {
			throwBadRequest("Category does not exist");
		}
		if (commandData.getCategoryIndex() == null) {
			commandData.setCategoryIndex(0);
		}
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
