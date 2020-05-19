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




package com.anfelisa.category.changeorder.scenarios;

import com.anfelisa.category.models.CategoryModel;
import com.anfelisa.category.models.ICategoryModel;

@SuppressWarnings("unused")
public class ChangeOrderScenario extends AbstractChangeOrderScenario {

	@Override
	protected void verifications() {
		ICategoryModel actualCategory1 = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "cat1-" + getTestId());
		ICategoryModel expectedCategory1 = new CategoryModel("cat1-" + getTestId(), "level 1 #1", "Annette-" + getTestId(), 1,"boxId-" + getTestId(),"boxId-" + getTestId(), false, null,
				null);
		assertThat(actualCategory1, expectedCategory1);

		ICategoryModel actualCategory2 = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "cat2-" + getTestId());
		ICategoryModel expectedCategory2 = new CategoryModel("cat2-" + getTestId(), "level 1 #2", "Annette-" + getTestId(), 3,"boxId-" + getTestId(),"boxId-" + getTestId(), false, null,
				null);
		assertThat(actualCategory2, expectedCategory2);
		
		ICategoryModel actualCategory3 = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "cat3-" + getTestId());
		ICategoryModel expectedCategory3 = new CategoryModel("cat3-" + getTestId(), "level 1 #3", "Annette-" + getTestId(), 2,"boxId-" + getTestId(),"boxId-" + getTestId(), false, null,
				null);
		assertThat(actualCategory3, expectedCategory3);
		
		ICategoryModel actualCategory4 = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "cat4-" + getTestId());
		ICategoryModel expectedCategory4 = new CategoryModel("cat4-" + getTestId(), "level 1 #4", "Annette-" + getTestId(), 4,"boxId-" + getTestId(),"boxId-" + getTestId(), false, null,
				null);
		assertThat(actualCategory4, expectedCategory4);
	}

}




/******* S.D.G. *******/



