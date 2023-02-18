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

import com.anfelisa.box.models.BoxCreationModel;
import com.anfelisa.box.models.BoxUpdateModel;
import com.anfelisa.box.models.DeleteBoxModel;

import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class RootCategoryView implements IRootCategoryView {

	private IDaoProvider daoProvider;
	
	public RootCategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	@Override
	public void insert(Data<BoxCreationModel> data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().insert(handle, data.getModel().mapToCategoryModel());
	}

	@Override
	public void update(Data<BoxUpdateModel> data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().update(handle, data.getModel());
	}

	@Override
	public void deleteAll(Data<DeleteBoxModel> data, PersistenceHandle handle) {
		daoProvider.getCardDao().deleteByRootCategoryId(handle, data.getModel().getRootCategoryId());
		daoProvider.getCategoryDao().deleteByRootCategoryId(handle, data.getModel().getRootCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, data.getModel().getRootCategoryId());
	}

}




/******* S.D.G. *******/



