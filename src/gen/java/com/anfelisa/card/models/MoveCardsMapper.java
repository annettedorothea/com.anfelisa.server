/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class MoveCardsMapper implements RowMapper<IMoveCardsModel> {
	
	public IMoveCardsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new MoveCardsModel(
			null,
			r.getString("categoryId"),
			r.getString("userId"),
			null,
			null
		);
	}
}



/******* S.D.G. *******/



