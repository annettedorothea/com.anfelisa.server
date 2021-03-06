/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ReinforceCardMapper implements RowMapper<IReinforceCardModel> {
	
	public IReinforceCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ReinforceCardModel(
			r.getString("reinforceCardId"),
			r.getString("scheduledCardId"),
			r.getString("boxId"),
			r.getTimestamp("changeDate") != null ? r.getTimestamp("changeDate").toLocalDateTime() : null
		);
	}
}



/******* S.D.G. *******/



