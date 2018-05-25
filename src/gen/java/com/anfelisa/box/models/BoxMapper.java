package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class BoxMapper implements ResultSetMapper<IBoxModel> {
	
	public IBoxModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxModel(
			r.getString("boxId"),
			r.getString("userId"),
			r.getString("categoryId"),
			r.getInt("maxInterval")
		);
	}
}

/*       S.D.G.       */
