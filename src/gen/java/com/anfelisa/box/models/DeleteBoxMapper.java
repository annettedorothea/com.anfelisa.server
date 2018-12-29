package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class DeleteBoxMapper implements RowMapper<IDeleteBoxModel> {
	
	public IDeleteBoxModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new DeleteBoxModel(
			r.getString("userId"),
			r.getString("boxId")
		);
	}
}

/*       S.D.G.       */
