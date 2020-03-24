package com.anfelisa.category.commands;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.data.ICategoryCreationData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class CreateCategoryCommand extends AbstractCreateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCategoryCommand.class);

	public CreateCategoryCommand(ICategoryCreationData actionData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		if (StringUtils.isBlank(this.commandData.getParentCategoryId())) {
			throwBadRequest("missing parent category id");
		}
		if (StringUtils.isBlank(this.commandData.getCategoryName())) {
			throwBadRequest("category name must not be null or empty");
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
		this.commandData.setCategoryId(commandData.getUuid());
		this.commandData.setCategoryAuthor(commandData.getUsername());

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
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
