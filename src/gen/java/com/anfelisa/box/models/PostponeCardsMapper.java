/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class PostponeCardsMapper implements RowMapper<IPostponeCardsModel> {
	
	public IPostponeCardsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new PostponeCardsModel(
			r.getObject("days") != null ? r.getInt("days") : null,
			r.getString("boxId")
		);
	}
}



/******* S.D.G. *******/



