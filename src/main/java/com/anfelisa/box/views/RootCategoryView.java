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

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.box.data.IBoxCreationData;
import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.data.IDeleteBoxData;

public class RootCategoryView implements IRootCategoryView {

	private IDaoProvider daoProvider;
	
	public RootCategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	@Override
	public void insert(IBoxCreationData data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().insert(handle, data);
	}

	@Override
	public void update(IBoxUpdateData data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().update(handle, data);
	}

	@Override
	public void deleteAll(IDeleteBoxData data, PersistenceHandle handle) {
		daoProvider.getCardDao().deleteByRootCategoryId(handle, data.getRootCategoryId());
		daoProvider.getCategoryDao().deleteByRootCategoryId(handle, data.getRootCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, data.getRootCategoryId());
	}

}




/******* S.D.G. *******/



