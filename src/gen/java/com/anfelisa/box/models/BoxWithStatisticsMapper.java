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
 *
 * generated with de.acegen 0.9.2
 *
 */




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class BoxWithStatisticsMapper implements RowMapper<IBoxWithStatisticsModel> {
	
	public IBoxWithStatisticsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxWithStatisticsModel(
			r.getObject("openTodaysCards") != null ? r.getInt("openTodaysCards") : null,
			r.getString("categoryName"),
			r.getString("categoryId"),
			r.getString("boxId"),
			r.getObject("quality0Count") != null ? r.getInt("quality0Count") : null,
			r.getObject("quality1Count") != null ? r.getInt("quality1Count") : null,
			r.getObject("quality2Count") != null ? r.getInt("quality2Count") : null,
			r.getObject("quality3Count") != null ? r.getInt("quality3Count") : null,
			r.getObject("quality4Count") != null ? r.getInt("quality4Count") : null,
			r.getObject("quality5Count") != null ? r.getInt("quality5Count") : null,
			null,
			r.getObject("maxCardsPerDay") != null ? r.getInt("maxCardsPerDay") : null
		);
	}
}



/******* S.D.G. *******/


