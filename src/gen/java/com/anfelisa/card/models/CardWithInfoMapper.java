/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CardWithInfoMapper implements RowMapper<ICardWithInfoModel> {
	
	public ICardWithInfoModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardWithInfoModel(
			r.getTimestamp("next") != null ? r.getTimestamp("next").toLocalDateTime() : null,
			r.getString("cardId"),
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getString("cardAuthor"),
			r.getObject("cardIndex") != null ? r.getInt("cardIndex") : null,
			r.getString("categoryId"),
			r.getString("rootCategoryId"),
			r.getObject("priority") != null ? r.getInt("priority") : null
		);
	}
}



/******* S.D.G. *******/



