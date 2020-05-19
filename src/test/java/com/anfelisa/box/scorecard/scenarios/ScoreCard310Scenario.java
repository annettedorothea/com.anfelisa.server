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




package com.anfelisa.box.scorecard.scenarios;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardModel;

@SuppressWarnings("unused")
public class ScoreCard310Scenario extends AbstractScoreCard310Scenario {

	@Override
	protected void verifications() {
		DateTime scoredDateTime = new DateTime(2022, 6, 1, 16, 30).withZone(DateTimeZone.UTC);

		IScheduledCardModel actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"score310-" + getTestId());
		IScheduledCardModel expectedScheduledCard = new ScheduledCardModel("score310-" + getTestId(), "c1-" + getTestId(),"boxId-" + getTestId(),
				scoredDateTime, 1.34F, 90, 12, 11, scoredDateTime.plusDays(90), 3, null,
				null);
		assertThat(actualScheduledCard, expectedScheduledCard);
	}

}




/******* S.D.G. *******/



