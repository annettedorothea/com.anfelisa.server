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
 * generated with de.acegen 0.9.2
 *
 */




package com.anfelisa.box.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.data.IScoreReinforceCardData;
import com.anfelisa.box.data.IScoreReinforceCardData;
import com.anfelisa.box.data.IInitMyBoxesDataData;
import com.anfelisa.box.data.IDeleteBoxData;
import com.anfelisa.box.data.ISortCardsOutData;

@SuppressWarnings("all")
public interface IReinforceCardView {

	void add(IScoreCardData data, PersistenceHandle handle);
	void remove(IScoreReinforceCardData data, PersistenceHandle handle);
	void update(IScoreReinforceCardData data, PersistenceHandle handle);
	void clear(IInitMyBoxesDataData data, PersistenceHandle handle);
	void deleteAll(IDeleteBoxData data, PersistenceHandle handle);
	void sortOut(ISortCardsOutData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



