package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.CategoryDeleteData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class DeleteCategoryCommand extends AbstractDeleteCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCategoryCommand.class);

	public DeleteCategoryCommand(CategoryDeleteData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(getHandle(), commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getCustomUserAccessToCategoryDao().selectByCategoryIdAndUserId(getHandle(), category.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		this.commandData.setCategoryIndex(category.getCategoryIndex());
		if (category.getParentCategoryId() == null) {
			this.commandData.setOutcome(root);
		} else {
			this.commandData.setParentCategoryId(category.getParentCategoryId());
			this.commandData.setOutcome(noRoot);
		}
	}

}

/*       S.D.G.       */
