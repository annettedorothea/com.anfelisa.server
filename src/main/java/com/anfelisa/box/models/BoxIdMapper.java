package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class BoxIdMapper implements ResultSetMapper<Integer> {

	public Integer map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return r.getInt("boxId");
	}
}

/* S.D.G. */
