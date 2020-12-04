package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.data.ICategoryDeleteData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class DeleteCategoryCommand extends AbstractDeleteCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCategoryCommand.class);

	public DeleteCategoryCommand(ICategoryDeleteData actionData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				commandData.getCategoryId());
		if (category == null) {
			throwIllegalArgumentException("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, category.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwSecurityException();
		}
		this.commandData.setCategoryIndex(category.getCategoryIndex());
		if (category.getParentCategoryId() == null) {
			throwIllegalArgumentException("rootCategoryMustNotBeDeleted");
		} else {
			this.commandData.setParentCategoryId(category.getParentCategoryId());
			this.addOkOutcome();
		}
	}

}

/* S.D.G. */
