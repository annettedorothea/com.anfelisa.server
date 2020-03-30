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

import javax.ws.rs.core.Response;

import com.anfelisa.category.models.CategoryModel;
import com.anfelisa.category.models.ICategoryModel;

@SuppressWarnings("unused")
public class ChangeOrderScenario extends AbstractChangeOrderScenario {

	@Override
	protected void verifications() {
		ICategoryModel actualCategory1 = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "cat1");
		ICategoryModel expectedCategory1 = new CategoryModel("cat1", "level 1 #1", "Annette", 1, "boxId", "boxId", false, null,
				null);
		assertThat(actualCategory1, expectedCategory1);

		ICategoryModel actualCategory2 = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "cat2");
		ICategoryModel expectedCategory2 = new CategoryModel("cat2", "level 1 #2", "Annette", 3, "boxId", "boxId", false, null,
				null);
		assertThat(actualCategory2, expectedCategory2);
		
		ICategoryModel actualCategory3 = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "cat3");
		ICategoryModel expectedCategory3 = new CategoryModel("cat3", "level 1 #3", "Annette", 2, "boxId", "boxId", false, null,
				null);
		assertThat(actualCategory3, expectedCategory3);
		
		ICategoryModel actualCategory4 = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "cat4");
		ICategoryModel expectedCategory4 = new CategoryModel("cat4", "level 1 #4", "Annette", 4, "boxId", "boxId", false, null,
				null);
		assertThat(actualCategory4, expectedCategory4);
	}

}




/******* S.D.G. *******/



