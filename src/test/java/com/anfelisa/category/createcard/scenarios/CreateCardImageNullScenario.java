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




package com.anfelisa.category.createcard.scenarios;

import javax.ws.rs.core.Response;

import com.anfelisa.card.models.CardModel;
import com.anfelisa.card.models.ICardModel;

@SuppressWarnings("unused")
public class CreateCardImageNullScenario extends AbstractCreateCardImageNullScenario {

	@Override
	protected void verifications() {
		ICardModel actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "c1");
		ICardModel expectedCard = new CardModel("c1", "given", "wanted", null, "Annette", 1, "cat1", "boxId");
		assertThat(actualCard, expectedCard);
	}

}




/******* S.D.G. *******/



