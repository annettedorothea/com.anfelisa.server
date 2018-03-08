package com.anfelisa.test.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class MyTestMapper implements ResultSetMapper<IMyTestModel> {
	
	public IMyTestModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MyTestModel(
			r.getInt("testId"),
			r.getString("name"),
			r.getInt("sequence"),
			r.getInt("resultCount"),
			r.getBoolean("hasResults")
		);
	}
}

/*       S.D.G.       */
