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




package com.anfelisa.box.createbox.scenarios;

import com.anfelisa.box.models.BoxModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.category.models.CategoryModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.category.models.UserAccessToCategoryModel;

@SuppressWarnings("unused")
public class CreateSecondBoxScenario extends AbstractCreateSecondBoxScenario {

	@Override
	protected void verifications() {
		ICategoryModel actualCategory = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "boxId2-" + getTestId());
		ICategoryModel expectedCategory = new CategoryModel("boxId2-" + getTestId(), "cat2-" + getTestId(), "Annette-" + getTestId(), 1, null, "boxId2-" + getTestId(), false, null,
				null);
		assertThat(actualCategory, expectedCategory);

		IUserAccessToCategoryModel actualAccessToCategory = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(handle, "boxId2-" + getTestId(), "uuid-" + getTestId());
		IUserAccessToCategoryModel expectedAccessToCategory = new UserAccessToCategoryModel("boxId2-" + getTestId(), "uuid-" + getTestId(), true);
		assertThat(actualAccessToCategory, expectedAccessToCategory);
		
		IBoxModel actualBox = this.daoProvider.getBoxDao().selectByBoxId(handle, "boxId2-" + getTestId());
		IBoxModel expectedBox = new BoxModel("boxId2-" + getTestId(), "uuid-" + getTestId(), "boxId2-" + getTestId(), null, 8);
		assertThat(actualBox, expectedBox);
	}

}




/******* S.D.G. *******/



