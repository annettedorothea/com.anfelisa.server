package com.anfelisa.category.commands;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class CreateCategoryCommand extends AbstractCreateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCategoryCommand.class);

	private final String[] languages = new String[] { "de", "fr", "en" };

	public CreateCategoryCommand(CategoryCreationData commandParam, DatabaseHandle databaseHandle,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCategoryId() != null
				&& daoProvider.getCategoryDao().selectByCategoryId(getHandle(), commandData.getCategoryId()) == null) {
			throwBadRequest("category does not exist");
		}
		
		this.commandData.setCategoryId(commandData.getUuid());
		if (commandData.getParentCategoryId() != null) {
			ICategoryModel parentCategory = this.daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
					commandData.getParentCategoryId());
			IUserAccessToCategoryModel access = this.daoProvider.getCustomUserAccessToCategoryDao().selectByCategoryIdAndUserId(getHandle(), parentCategory.getRootCategoryId(), commandData.getUserId());
			if (access == null) {
				throwUnauthorized();
			}
			commandData.setRootCategoryId(parentCategory.getRootCategoryId());
			commandData.setPath(parentCategory.getPath() + " -> " + commandData.getCategoryName());
			this.commandData.setOutcome(sub);
		} else {
			commandData.setRootCategoryId(commandData.getCategoryId());
			commandData.setPath(commandData.getCategoryName());
			this.commandData.setOutcome(root);
		}
		
		validateLanguage(commandData.getGivenLanguage());
		validateLanguage(commandData.getWantedLanguage());
		if (commandData.getDictionaryLookup() == null || !commandData.getDictionaryLookup()) {
			commandData.setGivenLanguage(null);
			commandData.setWantedLanguage(null);
		}
		
		if (commandData.getCategoryIndex() == null) {
			Integer max = null;
			if (commandData.getParentCategoryId() == null) {
				max = this.daoProvider.getCustomCategoryDao().selectMaxIndexInRootCategory(getHandle());
			} else {
				max = this.daoProvider.getCustomCategoryDao().selectMaxIndexInCategory(getHandle(),
						commandData.getParentCategoryId());
			}
			if (max == null) {
				max = 0;
			}
			commandData.setCategoryIndex(max + 1);
		}
	}
	
	private void validateLanguage(String language) {
		if (commandData.getDictionaryLookup() != null && commandData.getDictionaryLookup() == true
				&& language != null
				&& !Arrays.asList(languages).contains(language)) {
			throwBadRequest("invalid language");
		}

	}

}

/* S.D.G. */
