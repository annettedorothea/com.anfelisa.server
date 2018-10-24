package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class ReinforceCardMapper implements RowMapper<IReinforceCardModel> {
	
	public IReinforceCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ReinforceCardModel(
			r.getString("reinforceCardId"),
			r.getString("scheduledCardId"),
			r.getString("boxId"),
			r.getTimestamp("changeDate") != null ? new org.joda.time.DateTime(r.getTimestamp("changeDate")) : null
		);
	}
}

/*       S.D.G.       */
