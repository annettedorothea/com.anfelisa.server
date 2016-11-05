package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.DateTime;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class BoxMapper implements ResultSetMapper<IBoxModel> {
	
	public IBoxModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxModel(
			r.getInt("id"),
			r.getString("name"),
			r.getString("username")
		);
	}
}

/*       S.D.G.       */
