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

import javax.ws.rs.core.Response;

import com.anfelisa.auth.Roles;
import com.anfelisa.box.models.BoxModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.category.models.CategoryModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.category.models.UserAccessToCategoryModel;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserModel;

@SuppressWarnings("unused")
public class CreateBoxMinimalScenario extends AbstractCreateBoxMinimalScenario {

	@Override
	protected void verifications(Response response) {
		ICategoryModel actualCategory = this.daoProvider.getCategoryDao().selectByCategoryId(handle, "boxId");
		ICategoryModel expectedCategory = new CategoryModel("boxId", "cat", "Annette", 1, null, "boxId", false, null,
				null);
		assertThat(actualCategory, expectedCategory);

		IUserAccessToCategoryModel actualAccessToCategory = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(handle, "boxId", "uuid");
		IUserAccessToCategoryModel expectedAccessToCategory = new UserAccessToCategoryModel("boxId", "uuid", true);
		assertThat(actualAccessToCategory, expectedAccessToCategory);
		
		IBoxModel actualBox = this.daoProvider.getBoxDao().selectByBoxId(handle, "boxId");
		IBoxModel expectedBox = new BoxModel("boxId", "uuid", "boxId", null, 10);
		assertThat(actualBox, expectedBox);
	}

}

/******* S.D.G. *******/
