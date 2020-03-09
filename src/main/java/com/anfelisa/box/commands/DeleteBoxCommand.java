package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class DeleteBoxCommand extends AbstractDeleteBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteBoxCommand.class);

	public DeleteBoxCommand(IDeleteBoxData actionData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, this.commandData.getBoxId());
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwUnauthorized();
		}
		String rootCategoryId = box.getCategoryId();
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle, rootCategoryId);
		if (category == null) {
			throwBadRequest("category does not exist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, category.getRootCategoryId(), commandData.getUserId());
		if (access == null || access.getEditable() == false) {
			throwUnauthorized();
		}

		this.commandData.setAllReferencedCategories(
				daoProvider.getCategoryDao().selectAllByRootCategoryId(readonlyHandle, category.getRootCategoryId()));

		this.commandData.setRootCategoryId(rootCategoryId);
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
