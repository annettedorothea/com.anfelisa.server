package com.anfelisa.category.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.ICategoryCreationData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class CreateCategoryCommand extends AbstractCreateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCategoryCommand.class);

	public CreateCategoryCommand(ICategoryCreationData actionData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		this.commandData.setCategoryId(commandData.getUuid());
		this.commandData.setCategoryAuthor(commandData.getUsername());
		if (commandData.getParentCategoryId() == null) {
			throwBadRequest("missing parent category id");
		}
		if (this.commandData.getCategoryName() == null) {
			throwBadRequest("category name must not be null");
		}
		ICategoryModel parentCategory = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				commandData.getParentCategoryId());
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, parentCategory.getRootCategoryId(),
						commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		commandData.setRootCategoryId(parentCategory.getRootCategoryId());

		ICategoryModel rootCategory = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				parentCategory.getRootCategoryId());

		commandData.setDictionaryLookup(rootCategory.getDictionaryLookup());
		commandData.setGivenLanguage(rootCategory.getGivenLanguage());
		commandData.setWantedLanguage(rootCategory.getWantedLanguage());

		Integer max = this.daoProvider.getCategoryDao().selectMaxIndexInCategory(readonlyHandle,
				commandData.getParentCategoryId());
		if (max == null) {
			max = 0;
		}
		commandData.setCategoryIndex(max + 1);
		commandData.setEditable(true);
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
