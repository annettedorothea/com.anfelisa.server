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

package com.anfelisa.box.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.box.data.IBoxCreationData;
import com.anfelisa.box.data.IDeleteBoxData;

public class UserAccessToCategoryView implements IUserAccessToCategoryView {

	private IDaoProvider daoProvider;

	public UserAccessToCategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	@Override
	public void grantAccess(IBoxCreationData data, Handle handle) {
		daoProvider.getUserAccessToCategoryDao().insert(handle, data);
	}

	@Override
	public void delete(IDeleteBoxData data, Handle handle) {
		for (String categoryId : data.getAllReferencedCategories()) {
			daoProvider.getUserAccessToCategoryDao().deleteByCategoryId(handle, categoryId);
		}
		
	}

}

/******* S.D.G. *******/
