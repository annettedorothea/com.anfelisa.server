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




package com.anfelisa.box.sortcardsout.scenarios;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardModel;

@SuppressWarnings("unused")
public class SortCardsOutScenario extends AbstractSortCardsOutScenario {

	@Override
	protected void verifications() {
		DateTime dateTime = new DateTime(2020, 4, 18, 10, 30).withZone(DateTimeZone.UTC);

		IScheduledCardModel actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"c1-sc1");
		IScheduledCardModel expectedScheduledCard = new ScheduledCardModel("c1-sc1", "c1","boxId-" + getTestId(),
				dateTime, 2.5F, 1, 1, 0, null, null, null,
				null);
		assertThat(actualScheduledCard, expectedScheduledCard);

		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle, "c3-sc1");
		expectedScheduledCard = new ScheduledCardModel("c3-sc1", "c3","boxId-" + getTestId(),
				dateTime, 2.5F, 1, 1, 0, dateTime, null, null,
				null);
		assertThat(actualScheduledCard, expectedScheduledCard);
		
		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle, "c4-sc1");
		expectedScheduledCard = new ScheduledCardModel("c4-sc1", "c4","boxId-" + getTestId(),
				dateTime, 2.5F, 1, 1, 0, null, null, null,
				null);
		assertThat(actualScheduledCard, expectedScheduledCard);
		
		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectUnscoredByCardIdAndBoxId(handle, "c2","boxId-" + getTestId());
		assertIsNull(actualScheduledCard);
		
		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectUnscoredByCardIdAndBoxId(handle, "c5","boxId-" + getTestId());
		assertIsNull(actualScheduledCard);
	}

}




/******* S.D.G. *******/



