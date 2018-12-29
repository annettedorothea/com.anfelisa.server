package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class NextCardMapper implements RowMapper<INextCardModel> {
	
	public INextCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new NextCardModel(
			r.getString("scheduledCardId"),
			r.getString("cardId"),
			r.getTimestamp("scheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDate")) : null,
			r.getObject("lastQuality") != null ? r.getInt("lastQuality") : null,
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getString("categoryId"),
			r.getString("rootCategoryId"),
			r.getObject("count") != null ? r.getInt("count") : null,
			r.getTimestamp("scoredDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scoredDate")) : null,
			r.getString("boxId"),
			r.getString("userId"),
			r.getTimestamp("today") != null ? new org.joda.time.DateTime(r.getTimestamp("today")) : null
		);
	}
}

/*       S.D.G.       */
