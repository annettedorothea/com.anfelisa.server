package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.DateTime;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CardOfBoxMapper implements ResultSetMapper<ICardOfBoxModel> {
	
	public ICardOfBoxModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardOfBoxModel(
			r.getInt("carOfBoxId"),
			r.getInt("cardId"),
			r.getFloat("ef"),
			r.getInt("interval"),
			r.getInt("count"),
			new DateTime(r.getDate("date")),
			r.getInt("boxId"),
			r.getInt("quality"),
			new DateTime(r.getDate("timestamp")),
			r.getInt("points")
		);
	}
}

/*       S.D.G.       */
