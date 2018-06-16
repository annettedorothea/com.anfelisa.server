package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class DeleteBoxMapper implements ResultSetMapper<IDeleteBoxModel> {
	
	public IDeleteBoxModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new DeleteBoxModel(
			r.getString("userId"),
			r.getString("boxId")
		);
	}
}

/*       S.D.G.       */
