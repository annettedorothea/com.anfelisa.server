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

package com.anfelisa.category.createcategory.scenarios;

import javax.ws.rs.core.Response;

import com.anfelisa.category.models.CategoryModel;
import com.anfelisa.category.models.ICategoryModel;

@SuppressWarnings("unused")
public class CreateCategoryWithDictionaryLookupScenario extends AbstractCreateCategoryWithDictionaryLookupScenario {

	@Override
	protected void verifications() {
		ICategoryModel actualCategory = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "dict");
		ICategoryModel expectedCategory = new CategoryModel("dict", "dict", "Annette", 1, "boxId", "boxId", true, "de",
				"en");
		assertThat(actualCategory, expectedCategory);
	}

}

/******* S.D.G. *******/
