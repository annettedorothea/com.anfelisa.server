package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class CardSearchMapper implements ResultSetMapper<ICardSearchModel> {
	
	public ICardSearchModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardSearchModel(
			r.getString("given"),
			r.getString("wanted"),
			r.getString("categoryId"),
			null,
			r.getBoolean("naturalInputOrder")
		);
	}
}

/*       S.D.G.       */
