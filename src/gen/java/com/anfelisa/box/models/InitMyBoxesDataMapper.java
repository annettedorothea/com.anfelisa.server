/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class InitMyBoxesDataMapper implements RowMapper<IInitMyBoxesDataModel> {
	
	public IInitMyBoxesDataModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new InitMyBoxesDataModel(
			r.getString("userId"),
			r.getTimestamp("todayAtMidnightInUTC") != null ? r.getTimestamp("todayAtMidnightInUTC").toLocalDateTime() : null,
			null,
			null
		);
	}
}



/******* S.D.G. *******/



