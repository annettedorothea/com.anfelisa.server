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

package com.anfelisa.card.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.card.data.ICsvUploadData;
import com.anfelisa.card.models.CardModel;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.card.models.ISimpleCardModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ImportCsvCommand extends AbstractImportCsvCommand {

	static final Logger LOG = LoggerFactory.getLogger(ImportCsvCommand.class);

	public ImportCsvCommand(ICsvUploadData commandData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		ICategoryModel category = this.daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				commandData.getCategoryId());
		if (category == null) {
			throwIllegalArgumentException("categoryDoesNotExist");
		}
		IUserModel user = this.daoProvider.getUserDao().selectByUserId(readonlyHandle, commandData.getUserId());
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, category.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwSecurityException();
		}
		Integer max = this.daoProvider.getCardDao().selectMaxIndexInCategory(readonlyHandle,
				commandData.getCategoryId());
		if (max == null) {
			max = 0;
		}
		int index = max + 1;

		List<ICardModel> cards = new ArrayList<ICardModel>();
		List<ISimpleCardModel> preview = this.commandData.getPreviewCsv();
		if (preview != null) {
			for (ISimpleCardModel simpleCardModel : preview) {
				cards.add(new CardModel(
						simpleCardModel.getId(), 
						simpleCardModel.getGiven(),
						simpleCardModel.getWanted(),
						null, 
						user.getUsername(), 
						index, 
						commandData.getCategoryId(), 
						category.getRootCategoryId(), null));
				index++;
			}
		}
		this.commandData.setCards(cards);
		this.commandData.setOutcome(ok);
	}

}

/******* S.D.G. *******/
