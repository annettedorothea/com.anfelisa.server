/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.6
 *
 */




package com.anfelisa.category.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.category.data.ICategoryCreationData;
import com.anfelisa.category.data.ICategoryDeleteData;
import com.anfelisa.category.data.ICategoryUpdateData;
import com.anfelisa.category.data.ICategoryMoveData;
import com.anfelisa.category.data.ICategoryChangeOrderData;

@SuppressWarnings("all")
public interface ICategoryView {

	void insert(ICategoryCreationData data, PersistenceHandle handle);
	void delete(ICategoryDeleteData data, PersistenceHandle handle);
	void update(ICategoryUpdateData data, PersistenceHandle handle);
	void moveCategory(ICategoryMoveData data, PersistenceHandle handle);
	void changeOrder(ICategoryChangeOrderData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



