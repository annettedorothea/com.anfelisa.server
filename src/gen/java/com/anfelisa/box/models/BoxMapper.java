package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class BoxMapper implements RowMapper<IBoxModel> {
	
	public IBoxModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxModel(
			r.getString("boxId"),
			r.getString("userId"),
			r.getString("categoryId"),
			r.getObject("maxInterval") != null ? r.getInt("maxInterval") : null,
			r.getObject("maxCardsPerDay") != null ? r.getInt("maxCardsPerDay") : null
		);
	}
}

/*       S.D.G.       */
