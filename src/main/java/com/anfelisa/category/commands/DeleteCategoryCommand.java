package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.CategoryDeleteData;

public class DeleteCategoryCommand extends AbstractDeleteCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCategoryCommand.class);

	public DeleteCategoryCommand(CategoryDeleteData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (daoProvider.categoryDao.selectByCategoryId(getHandle(), commandData.getCategoryId()) == null) {
			throwBadRequest("Category does not exist");
		}
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
