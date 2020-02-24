/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.box.commands;

import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.IBoxCreationData;
import com.anfelisa.box.utils.LanguageValidator;

public class CreateBoxCommand extends AbstractCreateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxCommand.class);

	public CreateBoxCommand(IBoxCreationData commandData, IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		if (this.commandData.getMaxCardsPerDay() == null) {
			throwBadRequest("max cards per day must not be null");
		}
		if (this.commandData.getParentCategoryId() != null) {
			throwBadRequest("root category must not have a parent category");
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

		this.commandData.setCategoryId(commandData.getUuid());
		this.commandData.setCategoryAuthor(commandData.getUsername());
		commandData.setRootCategoryId(commandData.getCategoryId());
		this.commandData.setBoxId(commandData.getCategoryId());

		Integer max = this.daoProvider.getCategoryDao().selectMaxIndexInRootCategory(readonlyHandle);
		if (max == null) {
			max = 0;
		}
		commandData.setCategoryIndex(max + 1);
		commandData.setEditable(true);
		this.commandData.setOutcome(ok);
	}


}

/******* S.D.G. *******/
