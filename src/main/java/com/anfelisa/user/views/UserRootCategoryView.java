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

package com.anfelisa.user.views;

import com.anfelisa.user.data.IDeleteUserData;

import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class UserRootCategoryView implements IUserRootCategoryView {

	private IDaoProvider daoProvider;

	public UserRootCategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void deleteAll(IDeleteUserData data, PersistenceHandle handle) {
		for (String rootCategoryId : data.getRootCategoryIds()) {
			daoProvider.getCardDao().deleteByRootCategoryId(handle, rootCategoryId);
			daoProvider.getCategoryDao().deleteByRootCategoryId(handle, rootCategoryId);
			daoProvider.getCategoryDao().deleteByCategoryId(handle, rootCategoryId);
		}
	}

}

/******* S.D.G. *******/
