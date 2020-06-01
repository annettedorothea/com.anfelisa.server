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

package com.anfelisa.category.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.data.ICategoryChangeOrderData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ChangeOrderCategoryCommand extends AbstractChangeOrderCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeOrderCategoryCommand.class);

	public ChangeOrderCategoryCommand(ICategoryChangeOrderData commandData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		ICategoryModel targetCategory = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				commandData.getTargetCategoryId());
		if (targetCategory == null) {
			throwIllegalArgumentException("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel accessToRootCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, targetCategory.getRootCategoryId(), commandData.getUserId());
		if (accessToRootCategory == null) {
			throwSecurityException();
		}

		ICategoryModel movedCategory = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				commandData.getMovedCategoryId());
		if (movedCategory == null) {
			throwIllegalArgumentException("categoryDoesNotExist");
		}
		accessToRootCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, movedCategory.getRootCategoryId(), commandData.getUserId());
		if (accessToRootCategory == null) {
			throwSecurityException();
		}
		
		List<ICategoryModel> categories = this.daoProvider.getCategoryDao().selectAllChildren(readonlyHandle,
				targetCategory.getParentCategoryId());
		int index = 1;
		for (ICategoryModel category : categories) {
			if (category.getCategoryIndex() < targetCategory.getCategoryIndex()) {
				if (!commandData.getMovedCategoryId().equals(category.getCategoryId())) {
					category.setCategoryIndex(index);
					index++;
				}
			} else {
				break;
			}
		}
		for (ICategoryModel category : categories) {
			if (commandData.getMovedCategoryId().equals(category.getCategoryId())) {
				category.setCategoryIndex(index);
				index++;
				break;
			}
		}
		for (ICategoryModel category : categories) {
			if (category.getCategoryIndex() >= targetCategory.getCategoryIndex()) {
				if (!commandData.getMovedCategoryId().equals(category.getCategoryId())) {
					category.setCategoryIndex(index);
					index++;
				}
			}
		}
		this.commandData.setUpdatedIndices(categories);
		this.commandData.setOutcome(ok);
	}

}

/******* S.D.G. *******/
