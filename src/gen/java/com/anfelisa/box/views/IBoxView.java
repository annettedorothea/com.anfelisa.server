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
 * generated with de.acegen 0.9.7
 *
 */




package com.anfelisa.box.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.box.data.IBoxCreationData;
import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.data.IScheduledCardsData;
import com.anfelisa.box.data.ISortCardsOutData;

@SuppressWarnings("all")
public interface IBoxView {

	void createBox(IBoxCreationData data, PersistenceHandle handle);
	void updateBox(IBoxUpdateData data, PersistenceHandle handle);
	void deleteBox(IDeleteBoxData data, PersistenceHandle handle);
	void scheduleCards(IScheduledCardsData data, PersistenceHandle handle);
	void sortCardsOut(ISortCardsOutData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



