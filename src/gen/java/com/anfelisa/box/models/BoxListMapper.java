package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class BoxListMapper implements RowMapper<IBoxListModel> {
	
	public IBoxListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxListModel(
			null,
			r.getString("userId"),
			r.getTimestamp("today") != null ? new org.joda.time.DateTime(r.getTimestamp("today")) : null
		);
	}
}

/*       S.D.G.       */
