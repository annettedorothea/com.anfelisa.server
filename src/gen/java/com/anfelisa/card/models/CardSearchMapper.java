package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class CardSearchMapper implements RowMapper<ICardSearchModel> {
	
	public ICardSearchModel map(ResultSet r, StatementContext ctx) throws SQLException {
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
