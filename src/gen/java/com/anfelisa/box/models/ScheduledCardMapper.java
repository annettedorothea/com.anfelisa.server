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




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ScheduledCardMapper implements RowMapper<IScheduledCardModel> {
	
	public IScheduledCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduledCardModel(
			r.getString("scheduledCardId"),
			r.getString("cardId"),
			r.getString("boxId"),
			r.getTimestamp("createdDate") != null ? r.getTimestamp("createdDate").toLocalDateTime() : null,
			r.getFloat("ef"),
			r.getObject("interval") != null ? r.getInt("interval") : null,
			r.getObject("n") != null ? r.getInt("n") : null,
			r.getObject("count") != null ? r.getInt("count") : null,
			r.getTimestamp("scheduledDate") != null ? r.getTimestamp("scheduledDate").toLocalDateTime() : null,
			r.getObject("lastQuality") != null ? r.getInt("lastQuality") : null,
			r.getObject("quality") != null ? r.getInt("quality") : null,
			r.getTimestamp("scoredDate") != null ? r.getTimestamp("scoredDate").toLocalDateTime() : null
		);
	}
}




/******* S.D.G. *******/



