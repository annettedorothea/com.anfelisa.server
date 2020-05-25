package com.anfelisa.category.commands;

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
		ICategoryModel parentCategory = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				commandData.getParentCategoryId());
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, parentCategory.getRootCategoryId(),
						commandData.getUserId());
		if (access == null) {
			throwSecurityException();
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
