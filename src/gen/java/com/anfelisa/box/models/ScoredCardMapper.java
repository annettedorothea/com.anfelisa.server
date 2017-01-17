package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ScoredCardMapper implements ResultSetMapper<IScoredCardModel> {
	
	public IScoredCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoredCardModel(
			r.getInt("scoredCardId"),
			r.getInt("cardId"),
			new org.joda.time.DateTime(r.getDate("scheduledDateOfScored")),
			r.getInt("boxId"),
			r.getInt("quality"),
			new org.joda.time.DateTime(r.getDate("timestamp")),
			r.getInt("points"),
			r.getInt("scheduledCardId")
		);
	}
}

/*       S.D.G.       */
