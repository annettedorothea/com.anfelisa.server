package com.anfelisa.category.commands;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.CategoryUpdateData;
import com.anfelisa.category.models.ICategoryModel;

public class UpdateCategoryCommand extends AbstractUpdateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCategoryCommand.class);

	private final String[] languages = new String[] { "de", "fr", "en" };

	public UpdateCategoryCommand(CategoryUpdateData commandParam, DatabaseHandle databaseHandle,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("Category does not exist");
		}
		validateLanguage(commandData.getGivenLanguage());
		validateLanguage(commandData.getWantedLanguage());
		if (commandData.getDictionaryLookup() == null || !commandData.getDictionaryLookup()) {
			commandData.setGivenLanguage(null);
			commandData.setWantedLanguage(null);
		}
		if (commandData.getCategoryIndex() == null) {
			Integer max = null;
			if (category.getParentCategoryId() == null) {
				max = this.daoProvider.getCustomCategoryDao().selectMaxIndexInRootCategory(getHandle());
			} else {
				max = this.daoProvider.getCustomCategoryDao().selectMaxIndexInCategory(getHandle(),
						category.getParentCategoryId());
			}
			if (max == null) {
				max = 0;
			}
			commandData.setCategoryIndex(max + 1);
		}
		this.commandData.setOutcome(ok);
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