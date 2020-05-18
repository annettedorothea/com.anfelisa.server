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




package com.anfelisa.box.updatebox.scenarios;

import com.anfelisa.box.models.BoxModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.category.models.CategoryModel;
import com.anfelisa.category.models.ICategoryModel;

@SuppressWarnings("unused")
public class UpdateBoxMaxIntervalSetToNullScenario extends AbstractUpdateBoxMaxIntervalSetToNullScenario {

	@Override
	protected void verifications() {
		ICategoryModel actualCategory = this.daoProvider.getCategoryDao().selectByCategoryId(handle,"boxId-" + getTestId());
		ICategoryModel expectedCategory = new CategoryModel("boxId-" + getTestId(), "changed", "Annette-" + getTestId(), 1, null,"boxId-" + getTestId(), false, null,
				null);
		assertThat(actualCategory, expectedCategory);

		IBoxModel actualBox = this.daoProvider.getBoxDao().selectByBoxId(handle,"boxId-" + getTestId());
		IBoxModel expectedBox = new BoxModel("boxId-" + getTestId(), "uuid-" + getTestId(),"boxId-" + getTestId(), null, 11);
		assertThat(actualBox, expectedBox);
	}

}




/******* S.D.G. *******/



