package com.anfelisa.test.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class MyTestMapper implements ResultSetMapper<IMyTestModel> {
	
	public IMyTestModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MyTestModel(
			r.getInt("id"),
			r.getString("name"),
			r.getInt("sequence"),
			r.getInt("resultCount"),
			r.getInt("resultCount") > 0
		);
	}
}