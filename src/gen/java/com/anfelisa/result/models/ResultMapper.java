package com.anfelisa.result.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ResultMapper implements ResultSetMapper<IResultModel> {
	
	public IResultModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ResultModel(
			r.getInt("resultId"),
			r.getString("username"),
			r.getInt("testId"),
			new org.joda.time.DateTime(r.getDate("date")),
			r.getString("json"),
			r.getInt("points"),
			r.getInt("maxPoints")
		);
	}
}

/*       S.D.G.       */
