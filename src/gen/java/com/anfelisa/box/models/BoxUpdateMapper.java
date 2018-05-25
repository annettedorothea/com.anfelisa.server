package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class BoxUpdateMapper implements ResultSetMapper<IBoxUpdateModel> {
	
	public IBoxUpdateModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxUpdateModel(
			r.getString("boxId"),
			r.getString("name"),
			r.getInt("maxInterval")
		);
	}
}

/*       S.D.G.       */
