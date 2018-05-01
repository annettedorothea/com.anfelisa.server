package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.category.data.CategoryMoveData;
import com.anfelisa.category.models.CategoryDao;

public class MoveCategoryCommand extends AbstractMoveCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(MoveCategoryCommand.class);

	private CategoryDao categoryDao = new CategoryDao();

	public MoveCategoryCommand(CategoryMoveData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public MoveCategoryCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (categoryDao.selectByCategoryId(getHandle(), commandData.getCategoryId()) == null) {
			throwBadRequest("Category does not exist");
		}
		if (categoryDao.selectByCategoryId(getHandle(), commandData.getParentCategoryId()) == null) {
			throwBadRequest("Category does not exist");
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
