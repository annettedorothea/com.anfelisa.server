package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.CategoryCreationData;

public class CreateCategoryCommand extends AbstractCreateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCategoryCommand.class);

	public CreateCategoryCommand(CategoryCreationData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCategoryId() != null
				&& daoProvider.getCategoryDao().selectByCategoryId(getHandle(), commandData.getCategoryId()) == null) {
			throwBadRequest("category does not exist");
		}
		if (commandData.getCategoryIndex() == null) {
			Integer max = null;
			if (commandData.getParentCategoryId() == null) {
				max = this.daoProvider.getCustomCategoryDao().selectMaxIndexInRootCategory(getHandle());
			} else {
				max = this.daoProvider.getCustomCategoryDao().selectMaxIndexInCategory(getHandle(), commandData.getParentCategoryId());
			}
			if (max == null) {
				max = 0;
			}
			commandData.setCategoryIndex(max+1);
		}
		this.commandData.setCategoryId(commandData.getUuid());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
