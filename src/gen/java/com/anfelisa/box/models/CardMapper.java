package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.DateTime;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CardMapper implements ResultSetMapper<ICardModel> {
	
	public ICardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardModel(
			r.getInt("id"),
			r.getString("content"),
			r.getInt("testId"),
			r.getString("contentHash"),
			r.getInt("maxPoints")
		);
	}
}

/*       S.D.G.       */
