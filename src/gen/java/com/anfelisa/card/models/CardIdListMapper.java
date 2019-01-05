package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CardIdListMapper implements RowMapper<ICardIdListModel> {
	
	public ICardIdListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardIdListModel(
			null,
			r.getString("categoryId"),
			r.getString("userId"),
			null
		);
	}
}

/*       S.D.G.       */
