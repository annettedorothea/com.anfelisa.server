package com.anfelisa.category.commands;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.ICategoryUpdateData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class UpdateCategoryCommand extends AbstractUpdateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCategoryCommand.class);

	private final String[] languages = new String[] { "de", "fr", "en" };

	public UpdateCategoryCommand(ICategoryUpdateData actionData, DatabaseHandle databaseHandle,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(actionData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(getHandle(), category.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		validateLanguage(commandData.getGivenLanguage());
		validateLanguage(commandData.getWantedLanguage());
		if (commandData.getDictionaryLookup() == null || !commandData.getDictionaryLookup()) {
			commandData.setGivenLanguage(null);
			commandData.setWantedLanguage(null);
		}
		this.commandData.setOutcome(ok);
	}

	private void validateLanguage(String language) {
		if (commandData.getDictionaryLookup() != null && commandData.getDictionaryLookup() == true
				&& language != null
				&& !Arrays.asList(languages).contains(language)) {
			throwBadRequest("invalidLanguage");
		}

	}

}

/* S.D.G. */
