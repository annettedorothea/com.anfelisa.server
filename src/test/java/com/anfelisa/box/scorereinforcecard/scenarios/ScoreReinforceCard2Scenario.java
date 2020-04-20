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




package com.anfelisa.box.scorereinforcecard.scenarios;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;

import com.anfelisa.box.models.IReinforceCardModel;
import com.anfelisa.box.models.ReinforceCardModel;

@SuppressWarnings("unused")
public class ScoreReinforceCard2Scenario extends AbstractScoreReinforceCard2Scenario {

	@Override
	protected void verifications() {
		DateTime scoredDateTime = new DateTime(2020, 4, 18, 16, 40);
		IReinforceCardModel actualReinforceCard = this.daoProvider.getReinforceCardDao().selectByScheduledCardId(handle, "c1-sc1");
		IReinforceCardModel expectedReinforceCard = new ReinforceCardModel("score0", "c1-sc1", "boxId", scoredDateTime);
		assertThat(actualReinforceCard, expectedReinforceCard);
	}

}




/******* S.D.G. *******/



