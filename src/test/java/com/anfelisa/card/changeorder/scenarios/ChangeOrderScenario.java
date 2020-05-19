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

package com.anfelisa.card.changeorder.scenarios;

import com.anfelisa.card.models.CardModel;
import com.anfelisa.card.models.ICardModel;

@SuppressWarnings("unused")
public class ChangeOrderScenario extends AbstractChangeOrderScenario {

	@Override
	protected void verifications() {
		ICardModel actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "c3-" + getTestId());
		ICardModel expectedCard = new CardModel("c3-" + getTestId(), "3given", "3wanted", null, "Annette-" + getTestId(), 1, "cat1-" + getTestId(),"boxId-" + getTestId());
		assertThat(actualCard, expectedCard);

		actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "c4-" + getTestId());
		expectedCard = new CardModel("c4-" + getTestId(), "4given4", "4wanted4", null, "Annette-" + getTestId(), 2, "cat1-" + getTestId(),"boxId-" + getTestId());
		assertThat(actualCard, expectedCard);

		actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "c1-" + getTestId());
		expectedCard = new CardModel("c1-" + getTestId(), "given", "wanted", "image", "Annette-" + getTestId(), 3, "cat1-" + getTestId(),"boxId-" + getTestId());
		assertThat(actualCard, expectedCard);

		actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "c2-" + getTestId());
		expectedCard = new CardModel("c2-" + getTestId(), "given2", "wanted2", "image2", "Annette-" + getTestId(), 4, "cat1-" + getTestId(),"boxId-" + getTestId());
		assertThat(actualCard, expectedCard);

		actualCard = this.daoProvider.getCardDao().selectByCardId(handle, "c5-" + getTestId());
		expectedCard = new CardModel("c5-" + getTestId(), "different", "different", null, "Annette-" + getTestId(), 5, "cat1-" + getTestId(),"boxId-" + getTestId());
		assertThat(actualCard, expectedCard);
	}

}

/******* S.D.G. *******/
