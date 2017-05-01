package com.anfelisa.test.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class TestMapper implements ResultSetMapper<ITestModel> {
	
	public ITestModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new TestModel(
			r.getInt("testId"),
			r.getString("name"),
			r.getInt("sequence"),
			r.getInt("lessonId"),
			r.getString("html"),
			r.getString("author")
		);
	}
}

/*       S.D.G.       */
