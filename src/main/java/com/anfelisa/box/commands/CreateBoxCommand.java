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

import java.util.Arrays;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.IBoxCreationData;

public class CreateBoxCommand extends AbstractCreateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxCommand.class);

	private final String[] languages = new String[] { "de", "fr", "en" };

	public CreateBoxCommand(IBoxCreationData commandData, IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		this.commandData.setCategoryId(commandData.getUuid());
		this.commandData.setCategoryAuthor(commandData.getUsername());
		commandData.setRootCategoryId(commandData.getCategoryId());
		this.commandData.setBoxId(commandData.getCategoryId());
		if (this.commandData.getMaxCardsPerDay() == null) {
			throwBadRequest("max cards per day must not be null");
		}
		if (this.commandData.getParentCategoryId() != null) {
			throwBadRequest("root category must not have a parent category");
		}
		if (this.commandData.getCategoryName() == null) {
			throwBadRequest("category name must not be null");
		}

		validateLanguage(commandData.getGivenLanguage());
		validateLanguage(commandData.getWantedLanguage());
		if (commandData.getDictionaryLookup() == null || !commandData.getDictionaryLookup()) {
			commandData.setGivenLanguage(null);
			commandData.setWantedLanguage(null);
		}

		Integer max = this.daoProvider.getCategoryDao().selectMaxIndexInRootCategory(readonlyHandle);
		if (max == null) {
			max = 0;
		}
		commandData.setCategoryIndex(max + 1);
		commandData.setEditable(true);
		this.commandData.setOutcome(ok);
	}

	private void validateLanguage(String language) {
		if (commandData.getDictionaryLookup() != null && commandData.getDictionaryLookup() == true && language != null
				&& !Arrays.asList(languages).contains(language)) {
			throwBadRequest("invalidLanguage");
		}

	}

}

/******* S.D.G. *******/
