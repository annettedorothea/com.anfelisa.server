package com.anfelisa.result.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ResultMapper implements ResultSetMapper<IResultModel> {
	
	public IResultModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ResultModel(
			r.getString("resultId"),
			r.getString("username"),
			r.getString("testId"),
			r.getTimestamp("date") != null ? new org.joda.time.DateTime(r.getTimestamp("date")) : null,
			r.getString("json"),
			r.getInt("points"),
			r.getInt("maxPoints")
		);
	}
}

/*       S.D.G.       */
