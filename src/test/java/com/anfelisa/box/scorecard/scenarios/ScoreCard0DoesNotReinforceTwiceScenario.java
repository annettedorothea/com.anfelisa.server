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

import java.time.LocalDateTime;

import java.time.LocalDateTime;

import com.anfelisa.box.models.IReinforceCardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ReinforceCardModel;
import com.anfelisa.box.models.ScheduledCardModel;

@SuppressWarnings("unused")
public class ScoreCard0DoesNotReinforceTwiceScenario extends AbstractScoreCard0DoesNotReinforceTwiceScenario {

	@Override
	protected void verifications() {
		LocalDateTime scoredDateTime = LocalDateTime.of(2020, 4, 19, 16, 30);

		IScheduledCardModel actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"score01-" + getTestId());
		IScheduledCardModel expectedScheduledCard = new ScheduledCardModel("score01-" + getTestId(), "c1-" + getTestId(),"boxId-" + getTestId(),
				scoredDateTime, 2.5F, 1, 1, 2, scoredDateTime.plusDays(1), 0, null,
				null);
		assertThat(actualScheduledCard, expectedScheduledCard);

		LocalDateTime dateTime = LocalDateTime.of(2020, 4, 18, 16, 30);

		actualScheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				"score0-" + getTestId());
		expectedScheduledCard = new ScheduledCardModel("score0-" + getTestId(), "c1-" + getTestId(),"boxId-" + getTestId(),
				dateTime, 2.5F, 1, 1, 1, scoredDateTime, 0, 0,
				scoredDateTime);
		assertThat(actualScheduledCard, expectedScheduledCard);

		IReinforceCardModel actualReinforceCard = this.daoProvider.getReinforceCardDao().selectByScheduledCardId(handle,
				"c1-" + getTestId() + "-sc1-" + getTestId());
		IReinforceCardModel expectedReinforceCard = new ReinforceCardModel("score0-" + getTestId(), "c1-" + getTestId() + "-sc1-" + getTestId(),"boxId-" + getTestId(), dateTime);
		assertThat(actualReinforceCard, expectedReinforceCard);
	}

}

/******* S.D.G. *******/
