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




package com.anfelisa.box.initmyboxes.scenarios;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.anfelisa.box.models.IReinforceCardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ReinforceCardModel;
import com.anfelisa.box.models.ScheduledCardModel;

@SuppressWarnings("unused")
public class InitMyBoxesForDayWithScoredAndReinforceCardsSameDayDoesNothingScenario extends AbstractInitMyBoxesForDayWithScoredAndReinforceCardsSameDayDoesNothingScenario {

	@Override
	protected void verifications() {
		DateTime scoredDateTime = new DateTime(2020, 4, 18, 16, 30).withZone(DateTimeZone.UTC);

		IScheduledCardModel actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"score0");
		IScheduledCardModel expectedScheduledCard = new ScheduledCardModel("score0", "c1", "boxId",
				scoredDateTime, 2.5F, 1, 1, 1, scoredDateTime.plusDays(1), 0, null,
				null);
		assertThat(actualScheduledCard, expectedScheduledCard);

		DateTime dateTime = new DateTime(2020, 4, 16, 10, 30).withZone(DateTimeZone.UTC);

		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"c1-sc1");
		expectedScheduledCard = new ScheduledCardModel("c1-sc1", "c1", "boxId",
				dateTime, 2.5F, 1, 1, 0, dateTime, null, 0,
				scoredDateTime);
		assertThat(actualScheduledCard, expectedScheduledCard);

		IReinforceCardModel actualReinforceCard = this.daoProvider.getReinforceCardDao().selectByScheduledCardId(handle,
				"c1-sc1");
		IReinforceCardModel expectedReinforceCard = new ReinforceCardModel("score0", "c1-sc1", "boxId", scoredDateTime);
		assertThat(actualReinforceCard, expectedReinforceCard);

		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"score1");
		expectedScheduledCard = new ScheduledCardModel("score1", "c3", "boxId",
				scoredDateTime, 2.5F, 1, 1, 1, scoredDateTime.plusDays(1), 1, null,
				null);
		assertThat(actualScheduledCard, expectedScheduledCard);

		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"c3-sc1");
		expectedScheduledCard = new ScheduledCardModel("c3-sc1", "c3", "boxId",
				dateTime, 2.5F, 1, 1, 0, dateTime, null, 1,
				scoredDateTime);
		assertThat(actualScheduledCard, expectedScheduledCard);

		actualReinforceCard = this.daoProvider.getReinforceCardDao().selectByScheduledCardId(handle, "c3-sc1");
		expectedReinforceCard = new ReinforceCardModel("score1", "c3-sc1", "boxId", scoredDateTime);
		assertThat(actualReinforceCard, expectedReinforceCard);

		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"score5");
		expectedScheduledCard = new ScheduledCardModel("score5", "c4", "boxId",
				scoredDateTime, 2.6F, 6, 2, 1, scoredDateTime.plusDays(6), 5, null,
				null);
		assertThat(actualScheduledCard, expectedScheduledCard);

		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"c4-sc1");
		expectedScheduledCard = new ScheduledCardModel("c4-sc1", "c4", "boxId",
				dateTime, 2.5F, 1, 1, 0, dateTime, null, 5,
				scoredDateTime);
		assertThat(actualScheduledCard, expectedScheduledCard);

	}

}

/******* S.D.G. *******/

