package com.anfelisa.box.commands;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.utils.LanguageValidator;

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
			throwUnauthorized();
		}
		
		if (this.commandData.getMaxCardsPerDay() == null) {
			throwBadRequest("max cards per day must not be null");
		}
		if (StringUtils.isBlank(this.commandData.getCategoryName())) {
			throwBadRequest("category name must not be null or empty");
		}

		if (commandData.getDictionaryLookup() != null && commandData.getDictionaryLookup()) {
			if (!LanguageValidator.isLanguageValid(commandData.getGivenLanguage())) {
				throwBadRequest("given language is invalid");
			}
			if (!LanguageValidator.isLanguageValid(commandData.getWantedLanguage())) {
				throwBadRequest("wanted language is invalid");
			}
		} else {
			commandData.setGivenLanguage(null);
			commandData.setWantedLanguage(null);
		}

		this.commandData.setOutcome(AbstractUpdateBoxCommand.ok);
	}

}

/* S.D.G. */
