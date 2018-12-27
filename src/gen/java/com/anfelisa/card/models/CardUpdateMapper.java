package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class CardUpdateMapper implements RowMapper<ICardUpdateModel> {
	
	public ICardUpdateModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardUpdateModel(
			r.getString("cardId"),
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
