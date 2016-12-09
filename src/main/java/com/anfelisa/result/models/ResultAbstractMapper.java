package com.anfelisa.result.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ResultAbstractMapper implements ResultSetMapper<IResultAbstractModel> {

	public IResultAbstractModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ResultAbstractModel(
			r.getInt("resultId"),
			new org.joda.time.DateTime(r.getDate("date")),
			r.getInt("points"),
			r.getInt("maxPoints")
		);
	}

}
