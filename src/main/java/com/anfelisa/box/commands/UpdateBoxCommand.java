package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.utils.LanguageValidator;

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
			throwUnauthorized();
		}
		
		if (this.commandData.getMaxCardsPerDay() == 0) {
			throwBadRequest("max cards per day must not be zero");
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
