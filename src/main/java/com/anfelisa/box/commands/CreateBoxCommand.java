/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.BoxCreationModel;
import com.anfelisa.box.utils.LanguageValidator;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class CreateBoxCommand extends AbstractCreateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxCommand.class);

	public CreateBoxCommand(IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected Data<BoxCreationModel> executeCommand(Data<BoxCreationModel> data, PersistenceHandle readonlyHandle) {
		if (data.getModel().getDictionaryLookup() != null && data.getModel().getDictionaryLookup()) {
			if (!LanguageValidator.isLanguageValid(data.getModel().getGivenLanguage())) {
				throwIllegalArgumentException("givenLanguageIsInvalid");
			}
			if (!LanguageValidator.isLanguageValid(data.getModel().getWantedLanguage())) {
				throwIllegalArgumentException("wantedLanguageIsInvalid");
			}
		} else {
			data.getModel().setGivenLanguage(null);
			data.getModel().setWantedLanguage(null);
			data.getModel().setDictionaryLookup(false);
		}

		data.getModel().setCategoryId(data.getUuid());
		data.getModel().setCategoryAuthor(data.getModel().getUsername());
		data.getModel().setRootCategoryId(data.getModel().getCategoryId());
		data.getModel().setBoxId(data.getModel().getCategoryId());

		data.getModel().setCategoryIndex(null);
		data.getModel().setEditable(true);
		data.getModel().setArchived(false);
		data.getModel().setReverse(false);
		this.addOkOutcome(data);
		return data;
	}

}




/******* S.D.G. *******/



