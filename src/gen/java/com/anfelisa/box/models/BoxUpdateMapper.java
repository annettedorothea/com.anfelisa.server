package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class BoxUpdateMapper implements RowMapper<IBoxUpdateModel> {
	
	public IBoxUpdateModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxUpdateModel(
			r.getString("userId"),
			r.getString("boxId"),
			r.getObject("maxInterval") != null ? r.getInt("maxInterval") : null
		);
	}
}

/*       S.D.G.       */
