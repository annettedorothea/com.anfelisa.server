package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class CardIdMapper implements ResultSetMapper<ICardIdModel> {
	
	public ICardIdModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardIdModel(
			r.getString("cardId"),
			r.getString("testId"),
			r.getString("contentHash")
		);
	}
}

/*       S.D.G.       */
