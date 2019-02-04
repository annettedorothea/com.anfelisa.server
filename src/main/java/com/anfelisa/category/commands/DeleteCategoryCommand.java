package com.anfelisa.category.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.ICategoryDeleteData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class DeleteCategoryCommand extends AbstractDeleteCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCategoryCommand.class);

	public DeleteCategoryCommand(ICategoryDeleteData actionData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(actionData, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, category.getRootCategoryId(), commandData.getUserId());
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

/* S.D.G. */
