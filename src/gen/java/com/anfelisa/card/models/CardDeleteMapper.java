package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CardDeleteMapper implements RowMapper<ICardDeleteModel> {
	
	public ICardDeleteModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardDeleteModel(
			r.getString("cardId"),
			r.getObject("cardIndex") != null ? r.getInt("cardIndex") : null,
			r.getString("categoryId"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
