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




package com.anfelisa.card.importcsv.scenarios;

import javax.ws.rs.core.Response;

import com.anfelisa.card.models.CardModel;
import com.anfelisa.card.models.ICardModel;

@SuppressWarnings("unused")
public class ImportCsvNotEmptyScenario extends AbstractImportCsvNotEmptyScenario {

	@Override
	protected void verifications() {
		ICardModel actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "c1");
		ICardModel expectedCard = new CardModel("c1", "given", "wanted", "image", "Annette", 1, "cat1", "boxId");
		assertThat(actualCard, expectedCard);

		actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "1");
		expectedCard = new CardModel("1", "g1", "w1", null, "Annette", 2, "cat1", "boxId");
		assertThat(actualCard, expectedCard);

		actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "2");
		expectedCard = new CardModel("2", "g2", "w2", null, "Annette", 3, "cat1", "boxId");
		assertThat(actualCard, expectedCard);
		
		actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "3");
		expectedCard = new CardModel("3", "g3", "w3", null, "Annette", 4, "cat1", "boxId");
		assertThat(actualCard, expectedCard);
	}

}




/******* S.D.G. *******/



