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
 */




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ScoreCardMapper implements RowMapper<IScoreCardModel> {
	
	public IScoreCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoreCardModel(
			r.getString("cardId"),
			r.getString("nextScheduledCardScheduledCardId"),
			r.getTimestamp("nextScheduledCardCreatedDate") != null ? r.getTimestamp("nextScheduledCardCreatedDate").toLocalDateTime() : null,
			r.getFloat("nextScheduledCardEf"),
			r.getObject("nextScheduledCardInterval") != null ? r.getInt("nextScheduledCardInterval") : null,
			r.getObject("nextScheduledCardN") != null ? r.getInt("nextScheduledCardN") : null,
			r.getObject("nextScheduledCardCount") != null ? r.getInt("nextScheduledCardCount") : null,
			r.getTimestamp("nextScheduledCardScheduledDate") != null ? r.getTimestamp("nextScheduledCardScheduledDate").toLocalDateTime() : null,
			r.getObject("nextScheduledCardLastQuality") != null ? r.getInt("nextScheduledCardLastQuality") : null,
			r.getString("scheduledCardId"),
			r.getObject("scoredCardQuality") != null ? r.getInt("scoredCardQuality") : null,
			r.getTimestamp("scoredCardScoredDate") != null ? r.getTimestamp("scoredCardScoredDate").toLocalDateTime() : null,
			r.getString("reinforceCardId"),
			r.getTimestamp("reinforceCardCreatedDate") != null ? r.getTimestamp("reinforceCardCreatedDate").toLocalDateTime() : null,
			r.getString("userId"),
			r.getString("boxId")
		);
	}
}



/******* S.D.G. *******/



