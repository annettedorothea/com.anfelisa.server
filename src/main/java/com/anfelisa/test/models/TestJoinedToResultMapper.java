package com.anfelisa.test.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class TestJoinedToResultMapper implements ResultSetMapper<TestJoinedToResult> {
	
	public TestJoinedToResult map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		DateTime date = r.getObject("date") == null ? null : new DateTime(r.getDate("date"));
		Integer points = r.getObject("points") == null ? null : r.getInt("points");
		Integer maxPoints = r.getObject("maxPoints") == null ? null : r.getInt("maxPoints");
		String name = r.getString("name");
		Integer sequence = r.getInt("sequence");
		String testId = r.getString("testId");
		String resultId = r.getObject("resultId") == null ? null : r.getString("resultId");
		return new TestJoinedToResult(date, points, maxPoints, name, sequence, testId, resultId);
	}
	
}