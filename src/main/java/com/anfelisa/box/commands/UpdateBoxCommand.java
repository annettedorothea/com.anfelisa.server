package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.utils.LanguageValidator;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class UpdateBoxCommand extends AbstractUpdateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxCommand.class);

	public UpdateBoxCommand(IBoxUpdateData actionData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {

		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, this.commandData.getBoxId());
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwSecurityException();
		}
		IUserAccessToCategoryModel access = daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(readonlyHandle, box.getCategoryId(), commandData.getUserId());
		if (access == null) {
			throwSecurityException();
		}
		if (access.getEditable()) {
			this.addCanEditCategoryOutcome();
		}
		
		if (this.commandData.getMaxCardsPerDay() == 0) {
			throwIllegalArgumentException("maxCardsPerDayMustNotBeZero");
		}

		if (commandData.getDictionaryLookup() != null && commandData.getDictionaryLookup()) {
			if (!LanguageValidator.isLanguageValid(commandData.getGivenLanguage())) {
				throwIllegalArgumentException("givenLanguageIsInvalid");
			}
			if (!LanguageValidator.isLanguageValid(commandData.getWantedLanguage())) {
				throwIllegalArgumentException("wantedLanguageIsInvalid");
			}
		} else {
			commandData.setGivenLanguage(null);
			commandData.setWantedLanguage(null);
		}
		this.addOkOutcome();
	}

}

/* S.D.G. */
