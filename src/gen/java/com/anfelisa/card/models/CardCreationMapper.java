package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CardCreationMapper implements RowMapper<ICardCreationModel> {
	
	public ICardCreationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardCreationModel(
			r.getString("userId"),
			r.getString("username"),
			r.getString("cardId"),
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getString("cardAuthor"),
			r.getObject("cardIndex") != null ? r.getInt("cardIndex") : null,
			r.getString("categoryId"),
			r.getString("rootCategoryId"),
			r.getString("path")
		);
	}
}

/*       S.D.G.       */