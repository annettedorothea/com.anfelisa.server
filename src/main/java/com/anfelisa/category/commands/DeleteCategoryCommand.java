package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.category.data.CategoryDeleteData;
import com.anfelisa.category.models.CategoryDao;

public class DeleteCategoryCommand extends AbstractDeleteCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCategoryCommand.class);

	private CategoryDao categoryDao = new CategoryDao();
	
	public DeleteCategoryCommand(CategoryDeleteData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		if (categoryDao.selectByCategoryId(getHandle(), commandData.getCategoryId()) == null) {
			throwBadRequest("Category does not exist");
		}
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
