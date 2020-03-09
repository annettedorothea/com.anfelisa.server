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




package com.anfelisa.card.views;


import com.anfelisa.ace.IDataContainer;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.card.data.ICardDeleteData;
import com.anfelisa.card.data.ICardUpdateData;
import com.anfelisa.card.data.ICardIdListData;
import com.anfelisa.card.data.ICsvUploadData;
import com.anfelisa.card.data.IChangeCardOrderListData;

@SuppressWarnings("all")
public interface ICardView {

	void insert(ICardCreationData data, PersistenceHandle handle);
	void delete(ICardDeleteData data, PersistenceHandle handle);
	void update(ICardUpdateData data, PersistenceHandle handle);
	void moveCards(ICardIdListData data, PersistenceHandle handle);
	void bulkInsert(ICsvUploadData data, PersistenceHandle handle);
	void changeCardOrder(IChangeCardOrderListData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



